package com.o19s.es;

import org.apache.lucene.search.Query;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.search.internal.SearchContext;
import org.elasticsearch.test.AbstractQueryTestCase;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.instanceOf;

public class BackwardsQueryBuilderTests extends AbstractQueryTestCase<BackwardsQueryBuilder> {

    protected Collection<Class<? extends Plugin>> getPlugins() {
        return Collections.singletonList(BackwardsQueryParserPlugin.class);
    }

    @Override
    protected BackwardsQueryBuilder doCreateTestQueryBuilder() {
        BackwardsQueryBuilder queryBuilder = new BackwardsQueryBuilder();
        queryBuilder.query("foo");
        queryBuilder.field("bar");
        return queryBuilder;

    }

    @Override
    protected void doAssertLuceneQuery(BackwardsQueryBuilder queryBuilder, Query query, SearchContext context) throws IOException {
        assertThat(query, instanceOf(BackwardsTermQuery.class));
    }
}