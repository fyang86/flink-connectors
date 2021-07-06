/**
 * Copyright (c) Dell Inc., or its subsidiaries. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */

package io.pravega.connectors.flink.source.reader;

import io.pravega.client.stream.EventRead;
import io.pravega.connectors.flink.source.split.PravegaSplit;
import org.apache.flink.connector.base.source.reader.RecordsWithSplitIds;
import org.apache.flink.connector.base.source.reader.fetcher.SingleThreadFetcherManager;
import org.apache.flink.connector.base.source.reader.splitreader.SplitReader;
import org.apache.flink.connector.base.source.reader.synchronization.FutureCompletingBlockingQueue;

import java.util.function.Supplier;

/**
 * The SplitFetcherManager for Pravega source.
 */
public class PravegaFetcherManager<T>
        extends SingleThreadFetcherManager<EventRead<T>, PravegaSplit> {

    public PravegaFetcherManager(
            FutureCompletingBlockingQueue<RecordsWithSplitIds<EventRead<T>>> elementsQueue,
            Supplier<SplitReader<EventRead<T>, PravegaSplit>> splitReaderSupplier) {
        super(elementsQueue, splitReaderSupplier);
    }
}
