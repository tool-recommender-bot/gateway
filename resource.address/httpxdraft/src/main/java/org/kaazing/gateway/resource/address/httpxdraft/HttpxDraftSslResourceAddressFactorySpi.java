/**
 * Copyright 2007-2015, Kaazing Corporation. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kaazing.gateway.resource.address.httpxdraft;

import static org.kaazing.gateway.resource.address.ResourceFactories.changeSchemeOnly;
import static org.kaazing.gateway.resource.address.httpxdraft.HttpxDraftResourceAddressFactorySpi.PROTOCOL_NAME;

import org.kaazing.gateway.resource.address.ResourceFactory;
import org.kaazing.gateway.resource.address.http.HttpsResourceAddressFactorySpi;

public class HttpxDraftSslResourceAddressFactorySpi extends HttpsResourceAddressFactorySpi {

    private static final String SCHEME_NAME = "httpx-draft+ssl";
    private static final ResourceFactory TRANSPORT_FACTORY = changeSchemeOnly("ws-draft+ssl");

    @Override
    public String getSchemeName() {
        return SCHEME_NAME;
    }

    @Override
    protected ResourceFactory getTransportFactory() {
        return TRANSPORT_FACTORY;
    }

    @Override
    protected String getProtocolName() {
        return PROTOCOL_NAME;
    }

}
