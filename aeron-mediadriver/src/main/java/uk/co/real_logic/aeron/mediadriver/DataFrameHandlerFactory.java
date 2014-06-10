/*
 * Copyright 2014 Real Logic Ltd.
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
package uk.co.real_logic.aeron.mediadriver;

import uk.co.real_logic.aeron.util.AtomicArray;

public class DataFrameHandlerFactory
{
    private final NioSelector selector;
    private final MediaConductorProxy conductorProxy;

    public DataFrameHandlerFactory(final NioSelector selector, final MediaConductorProxy conductorProxy)
    {
        this.selector = selector;
        this.conductorProxy = conductorProxy;
    }

    public DataFrameHandler newInstance(final UdpDestination rcvDestination,
                                        final AtomicArray<SubscribedSession> globallySubscribedSessions)
        throws Exception
    {
        return new DataFrameHandler(rcvDestination, selector, conductorProxy, globallySubscribedSessions);
    }
}
