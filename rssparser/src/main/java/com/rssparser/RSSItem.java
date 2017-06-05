/*
 * Copyright (C) 2017 chatRG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.rssparser;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RSSItem implements Comparable<RSSItem>, Parcelable {

    private RSSFeed feed;
    private String title;
    private String link;
    private Date pubDate;
    private String description;
    private String content;
    private String author;


    public RSSItem() {

    }

    public RSSItem(Parcel source) {

        Bundle data = source.readBundle();
        title = data.getString("title");
        link = data.getString("link");
        pubDate = (Date) data.getSerializable("pubDate");
        description = data.getString("description");
        content = data.getString("content");
        author = data.getString("author");
        feed = data.getParcelable("feed");
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        Bundle data = new Bundle();
        data.putString("title", title);
        data.putString("link", link);
        data.putSerializable("pubDate", pubDate);
        data.putString("description", description);
        data.putString("content", content);
        data.putString("author", author);
        data.putParcelable("feed", feed);
        dest.writeBundle(data);
    }

    public static final Parcelable.Creator<RSSItem> CREATOR = new Parcelable.Creator<RSSItem>() {
        public RSSItem createFromParcel(Parcel data) {
            return new RSSItem(data);
        }

        public RSSItem[] newArray(int size) {
            return new RSSItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public RSSFeed getFeed() {
        return feed;
    }

    public void setFeed(RSSFeed feed) {
        this.feed = feed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setPubDate(String pubDate) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM, yyyy HH:mm:ss z", Locale.ENGLISH);
            this.pubDate = dateFormat.parse(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int compareTo(@NonNull RSSItem another) {
        if (getPubDate() != null && another.getPubDate() != null) {
            return getPubDate().compareTo(another.getPubDate());
        } else {
            return 0;
        }
    }

}