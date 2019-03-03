package com.o19s.es;

import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.test.ESIntegTestCase;

import java.util.Collection;
import java.util.Collections;

public class BackwardsQueryITTests extends ESIntegTestCase {

    /**
     * Returns a collection of plugins that should be loaded on each node.
     */
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        return Collections.singletonList(BackwardsQueryParserPlugin.class);
    }

    public void testSetupModel() {
        //assertAcked(prepareCreate("test1").setSettings(indexSettings()));
        assert(true);

    }
}
