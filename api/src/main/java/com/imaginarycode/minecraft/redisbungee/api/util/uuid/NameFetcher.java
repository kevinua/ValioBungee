/*
 * Copyright (c) 2013-present RedisBungee contributors
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 *
 *  http://www.eclipse.org/legal/epl-v10.html
 */

package com.imaginarycode.minecraft.redisbungee.api.util.uuid;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NameFetcher {
    private static final OkHttpClient httpClient = new OkHttpClient();
    private static final Gson gson = new Gson();

    public static List<String> nameHistoryFromUuid(UUID uuid) throws IOException {
        String name = getName(uuid);
        if (name == null) return Collections.emptyList();
        return Collections.singletonList(name);
    }

    public static String getName(UUID uuid) throws IOException {
        String url = "https://playerdb.co/api/player/minecraft/" + uuid.toString();
        Request request = new Request.Builder()
                .addHeader("User-Agent", "RedisBungee-ProxioDev")
                .url(url)
                .get()
                .build();
        ResponseBody body = httpClient.newCall(request).execute().body();
        String response = body.string();
        body.close();

        JsonObject json = gson.fromJson(response, JsonObject.class);
        if (!json.has("success") || !json.get("success").getAsBoolean()) return null;
        if (!json.has("data")) return null;
        JsonObject data = json.getAsJsonObject("data");
        if (!data.has("player")) return null;
        JsonObject player = data.getAsJsonObject("player");
        if (!player.has("username")) return null;

        return player.get("username").getAsString();
    }
}