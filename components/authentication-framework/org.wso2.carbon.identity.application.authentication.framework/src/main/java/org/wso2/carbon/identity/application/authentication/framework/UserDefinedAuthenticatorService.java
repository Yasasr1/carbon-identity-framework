/*
 * Copyright (c) 2025, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.application.authentication.framework;

import org.wso2.carbon.identity.application.common.model.UserDefinedFederatedAuthenticatorConfig;
import org.wso2.carbon.identity.application.common.model.UserDefinedLocalAuthenticatorConfig;

/**
 * The UserDefinedAuthenticatorService which responsible for creating ApplicationAuthenticator for the provided user
 * defined authenticator configs.
 */
public interface UserDefinedAuthenticatorService {

    /**
     * Get the ApplicationAuthenticator for the given user defined federated authenticator config.
     *
     * @param config    Federated Authenticator Config.
     * @return  FederatedApplicationAuthenticator instance.
     */
     FederatedApplicationAuthenticator getUserDefinedFederatedAuthenticator(
             UserDefinedFederatedAuthenticatorConfig config);

    /**
     * Get the ApplicationAuthenticator for the given user defined local authenticator config.
     *
     * @param config    Local Authenticator Config.
     * @return  LocalApplicationAuthenticator instance.
     */
    LocalApplicationAuthenticator getUserDefinedLocalAuthenticator(UserDefinedLocalAuthenticatorConfig config);
}
