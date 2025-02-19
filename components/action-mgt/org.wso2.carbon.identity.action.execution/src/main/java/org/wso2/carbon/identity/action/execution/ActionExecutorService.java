/*
 * Copyright (c) 2024, WSO2 LLC. (http://www.wso2.com).
 *
 * WSO2 LLC. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.action.execution;

import org.wso2.carbon.identity.action.execution.exception.ActionExecutionException;
import org.wso2.carbon.identity.action.execution.model.ActionExecutionStatus;
import org.wso2.carbon.identity.action.execution.model.ActionType;
import org.wso2.carbon.identity.action.execution.model.FlowContext;

import java.util.Map;

/**
 * This interface defines the Action Executor Service.
 * Action Executor Service is the component that is responsible for executing the action based on the action type
 * and the event context.
 */
public interface ActionExecutorService {

    /**
     * Check whether the execution is enabled for the given action type at the server level.
     *
     * @param actionType Action Type
     * @return True if the execution is enabled, False otherwise.
     */
    boolean isExecutionEnabled(ActionType actionType);

    /**
     * Execute the action based on the action type and the event context.
     *
     * @param actionType   Action Type
     * @param eventContext Context information required for the action execution.
     * @param tenantDomain Tenant Domain
     * @return {@link ActionExecutionStatus} The status of the action execution and the response context.
     * @throws ActionExecutionException If an error occurs while executing the action.
     */
    ActionExecutionStatus execute(ActionType actionType, Map<String, Object> eventContext, String tenantDomain) throws
            ActionExecutionException;

    /**
     * Resolve the action from given action id and execute it.
     *
     * @param actionType    Action Type.
     * @param actionId      The action Id of the action that need to be executed.
     * @param eventContext  The event context of the corresponding flow.
     * @param tenantDomain  Tenant domain.
     * @return {@link ActionExecutionStatus} The status of the action execution and the response context.
     * @throws ActionExecutionException If an error occurs while executing the action.
     */
    ActionExecutionStatus execute(ActionType actionType, String actionId,
                                            Map<String, Object> eventContext, String tenantDomain)
            throws ActionExecutionException;

    /**
     * Execute the action based on the action type and the flow context.
     *
     * @param actionType   Action Type
     * @param flowContext  Flow context of the corresponding flow
     * @param tenantDomain Tenant Domain
     * @return {@link ActionExecutionStatus} The status of the action execution and the response context
     * @throws ActionExecutionException If an error occurs while executing the action
     */
    default ActionExecutionStatus execute(ActionType actionType, FlowContext flowContext, String tenantDomain)
            throws ActionExecutionException {

        return execute(actionType, flowContext.getContextData(), tenantDomain);
    }

    /**
     * Execute the action based on the action type and the flow context.
     *
     * @param actionType   Action Type
     * @param actionId     The action id of the action that need to be executed
     * @param flowContext  Flow context of the corresponding flow
     * @param tenantDomain Tenant Domain
     * @return {@link ActionExecutionStatus} The status of the action execution and the response context
     * @throws ActionExecutionException If an error occurs while executing the action
     */
    default ActionExecutionStatus execute(ActionType actionType, String actionId,
                                          FlowContext flowContext, String tenantDomain)
            throws ActionExecutionException {

        return execute(actionType, actionId, flowContext.getContextData(), tenantDomain);
    }
}
