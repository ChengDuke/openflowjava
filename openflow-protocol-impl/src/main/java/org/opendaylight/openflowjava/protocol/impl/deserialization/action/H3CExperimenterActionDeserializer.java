package org.opendaylight.openflowjava.protocol.impl.deserialization.action;

import org.opendaylight.openflowjava.protocol.api.util.EncodeConstants;
import org.opendaylight.openflowjava.util.ByteBufUtils;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.action.grouping.ActionChoice;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.action.grouping.action.choice.ExperimenterCaseBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.action.grouping.action.choice.experimenter._case.ExperimenterActionBuilder;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.Action;
import org.opendaylight.yang.gen.v1.urn.opendaylight.openflow.common.action.rev150203.actions.grouping.ActionBuilder;

import io.netty.buffer.ByteBuf;

public class H3CExperimenterActionDeserializer extends AbstractActionDeserializer{

	@Override
	public Action deserialize(ByteBuf input) {
		ActionBuilder builder = new ActionBuilder();
		input.skipBytes(2 * EncodeConstants.SIZE_OF_SHORT_IN_BYTES);
		ExperimenterCaseBuilder caseBuilder = new ExperimenterCaseBuilder();
		ExperimenterActionBuilder actionBuilder = new ExperimenterActionBuilder();
		actionBuilder.setNextHop(ByteBufUtils.readIetfIpv4Address(input));
		caseBuilder.setExperimenterAction(actionBuilder.build());
		builder.setActionChoice(caseBuilder.build());
		return null;
	}

	@Override
	protected ActionChoice getType() {
		return new ExperimenterCaseBuilder().build();
	}

}
