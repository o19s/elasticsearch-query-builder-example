/*
 * Copyright [2016] Doug Turnbull
 *
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

import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.plugins.ActionPlugin;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.plugins.ScriptPlugin;
import org.elasticsearch.plugins.SearchPlugin;

import java.util.List;

import static java.util.Arrays.asList;
//import org.elasticsearch.index.IndexModule;

public class BackwardsQueryParserPlugin extends Plugin implements SearchPlugin, ScriptPlugin, ActionPlugin, AnalysisPlugin {

    public BackwardsQueryParserPlugin(Settings settings) {
    }

    @Override
    public List<QuerySpec<?>> getQueries() {

        return asList(
                new QuerySpec<>(BackwardsQueryBuilder.NAME, BackwardsQueryBuilder::new, BackwardsQueryBuilder::fromXContent));
    }

    // How to build a custom similarity
//    @Override
//    public void onIndexModule(IndexModule indexModule) {
//        indexModule.addSimilarity("simple-similarity", SimpleSimilarityProvider::new);
//    }

}
