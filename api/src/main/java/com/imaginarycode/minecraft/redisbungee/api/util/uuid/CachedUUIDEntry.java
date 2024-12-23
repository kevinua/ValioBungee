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

import java.util.Calendar;
import java.util.UUID;

public record CachedUUIDEntry(String name, UUID uuid, Calendar expiry) {

    public boolean expired() {
        return Calendar.getInstance().after(expiry);
    }
}
