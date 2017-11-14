/*
 * Copyright (c) 2013 Pantheon Technologies s.r.o. and others. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.openflowjava.protocol.impl.serialization.action;

import org.opendaylight.openflowjava.protocol.impl.util.ActionConstants;
import org.opendaylight.yang.gen.v1.urn.ietf.params.xml.ns.yang.ietf.inet.types.rev130715.IetfInetUtil;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.action.grouping.action.choice.ExperimenterCase;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.Action;

import io.netty.buffer.ByteBuf;

/**
 * @author Chengzhiwei
 *
 */
public class H3CExperimenterActionSerializer extends AbstractActionSerializer{
	
	@Override
    public void serialize(final Action action, final ByteBuf outBuffer) {
		super.serialize(action, outBuffer);
		outBuffer.writeBytes(IetfInetUtil.INSTANCE.ipv4AddressBytes(
				((ExperimenterCase)action.getActionChoice())
				.getExperimenterAction().getNextHop()
				));
	}

	@Override
	protected int getType() {
		return ActionConstants.EXP_NEXT_HOP_CODE;
	}

	@Override
	protected int getLength() {
		return ActionConstants.GENERAL_ACTION_LENGTH;
	}

}
