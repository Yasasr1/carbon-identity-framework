/*
 * Copyright (c) 2023, WSO2 LLC. (http://www.wso2.com).
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

package org.wso2.carbon.identity.application.common.model;

import org.apache.axiom.om.OMElement;

import java.io.Serializable;
import java.util.Iterator;

import javax.xml.bind.annotation.XmlElement;

/**
 * Representation of an ExternalConsentManagement Config.
 */
public class ExternalConsentManagementConfig implements Serializable {

    private static final long serialVersionUID = 928301275168169633L;

    private static final String ENABLED_ELEM = "Enabled";
    private static final String URL_ELEM = "ConsentUrl";

    @XmlElement(name = ENABLED_ELEM)
    private boolean enabled;

    @XmlElement(name = URL_ELEM)
    private String consentUrl;

    public boolean isEnabled() {

        return enabled;
    }

    public void setEnabled(boolean enabled) {

        this.enabled = enabled;
    }

    public String getExternalConsentUrl() {

        return consentUrl;
    }

    public void setExternalConsentUrl(String consentUrl) {

        this.consentUrl = consentUrl;
    }

    /**
     * Returns a ExternalConsentManagementConfig instance populated from the given OMElement
     * The OMElement is of the form below
     * <ExternalConsentManagementConfiguration>
     * <Enabled></Enabled>
     * <ConsentUrl></ConsentUrl>
     * </ExternalConsentManagementConfiguration>
     *
     * @param externalConsentManagementConfigOM OMElement to populate externalConsentManagementConfig
     * @return populated ExternalConsentManagementConfig instance
     */
    public static ExternalConsentManagementConfig build(OMElement externalConsentManagementConfigOM) {

        ExternalConsentManagementConfig externalConsentManagementConfig = new ExternalConsentManagementConfig();

        if (externalConsentManagementConfigOM == null) {
            return externalConsentManagementConfig;
        }

        Iterator<?> iterator = externalConsentManagementConfigOM.getChildElements();
        while (iterator.hasNext()) {
            OMElement omElement = (OMElement) iterator.next();
            if (ENABLED_ELEM.equals(omElement.getLocalName())) {
                externalConsentManagementConfig.setEnabled(
                                Boolean.parseBoolean(omElement.getText()));
            } else if (URL_ELEM.equals(omElement.getLocalName())) {
                externalConsentManagementConfig.setExternalConsentUrl(omElement.getText());
            }
        }

        return externalConsentManagementConfig;
    }

}
