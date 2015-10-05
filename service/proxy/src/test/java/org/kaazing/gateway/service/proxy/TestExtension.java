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
package org.kaazing.gateway.service.proxy;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.util.concurrent.CountDownLatch;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.kaazing.gateway.service.ServiceProperties;
import org.kaazing.mina.core.session.IoSessionEx;

public class TestExtension implements ProxyServiceExtensionSpi {
    static CountDownLatch latch;

    public TestExtension() {
        latch = new CountDownLatch(3);
    }

    @Override
    public void initAcceptSession(IoSession session, ServiceProperties properties) {
        latch.countDown();
    }
    @Override
    public void initConnectSession(IoSession session, ServiceProperties properties) {
        latch.countDown();
    }
    @Override
    public void proxiedConnectionEstablished(IoSessionEx acceptSession, IoSessionEx connectSession) {
        connectSession.write(IoBuffer.wrap("injected".getBytes(UTF_8)));
        latch.countDown();
    }

}
