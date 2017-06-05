<div align="center">
<h1>Android RSS Parser</h1>

[![](https://img.shields.io/badge/build-stable-brightgreen.svg?style=flat)]()
[![](https://img.shields.io/badge/version-0.1-blue.svg?style=flat)]()
[![Apache 2.0](https://img.shields.io/badge/license-Apache%202.0-orange.svg)](https://raw.githubusercontent.com/chatRG/RSS-parser/master/License.txt)

</div>

----

#### Library to parse RSS easily and efficiently.
> Basically, making the repeated task of parsing the feed easy.

Usage
----

Read the feed from the URL:
```java
URL url = new URL("http://example.com/feed");
RSSFeed feed = RSSReader.read(url);
```

Iterating through the feed:
```java
ArrayList<RSSItem> rssItems = feed.getRSSItems();
for(RSSItem item : rssItems) {
	Log.i("RSS Parser", item.getTitle());
}
````


License
----

    Copyright 2017 chatRG

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.