/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.o19s.es;

import com.o19s.es.BackwardsTermQuery;
import org.apache.lucene.search.Query;
import org.elasticsearch.common.ParseField;
import org.elasticsearch.common.ParsingException;
import org.elasticsearch.common.io.stream.NamedWriteable;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.ObjectParser;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.QueryShardContext;

import java.io.IOException;
import java.util.Objects;

public class BackwardsQueryBuilder extends AbstractQueryBuilder<BackwardsQueryBuilder> implements NamedWriteable {
    public static final String NAME = "backwards";

    private static final ParseField QUERY_NAME = new ParseField("query");
    private static final ParseField FIELD_NAME = new ParseField("field");

    private static final ObjectParser<BackwardsQueryBuilder, Void> PARSER;

    static {
        PARSER = new ObjectParser<>(NAME, BackwardsQueryBuilder::new);
        PARSER.declareString(BackwardsQueryBuilder::query, QUERY_NAME);
        PARSER.declareString(BackwardsQueryBuilder::field, FIELD_NAME);


        AbstractQueryBuilder.declareStandardFields(PARSER);
    }

    private String _query;
    private String _field;

    public BackwardsQueryBuilder() {
    }


    public BackwardsQueryBuilder(StreamInput in) throws IOException {
        super(in);
        _query = in.readString();
        _field = in.readString();
    }

    public static BackwardsQueryBuilder fromXContent(XContentParser parser) throws IOException {
        final BackwardsQueryBuilder builder;

        try {
            builder = PARSER.parse(parser, null);
        } catch (IllegalArgumentException iae) {
            throw new ParsingException(parser.getTokenLocation(), iae.getMessage(), iae);
        }

        if (builder._query == null) {
            throw new ParsingException(parser.getTokenLocation(), "Field [" + QUERY_NAME + "] is mandatory.");
        }

        if (builder._field == null) {
            throw new ParsingException(parser.getTokenLocation(), "Field [" + FIELD_NAME + "] is mandatory.");
        }
        return builder;
    }

    @Override
    protected void doWriteTo(StreamOutput out) throws IOException {
        out.writeString(_field);
        out.writeString(_query);
    }

    @Override
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject(NAME);
        printBoostAndQueryName(builder);
        builder.field(QUERY_NAME.getPreferredName(), _query);
        builder.endObject();
    }

    @Override
    protected Query doToQuery(QueryShardContext context) throws IOException {
        return new BackwardsTermQuery(_field, _query);
    }

    @Override
    protected int doHashCode() {
        return Objects.hash(_query, _field);
    }

    @Override
    protected boolean doEquals(BackwardsQueryBuilder other) {
        return Objects.equals(_query, other._query)
                && Objects.equals(_field, other._field);
    }

    @Override
    public String getWriteableName() {
        return NAME;
    }

    public String query() {
        return _query;
    }

    public BackwardsQueryBuilder query(String query) {
        this._query = query;
        return this;
    }

    public String field() {
        return _query;
    }

    public BackwardsQueryBuilder field(String field) {
        this._field = field;
        return this;
    }
}
