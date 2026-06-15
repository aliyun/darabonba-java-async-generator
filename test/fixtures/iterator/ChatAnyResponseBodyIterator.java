// This file is auto-generated, don't edit it. Thanks.
package com.aliyun.models;

import com.aliyun.core.utils.ParseUtil;
import darabonba.core.sse.SSEResponseIterator;

import java.util.*;

public class ChatAnyResponseBodyIterator extends SSEResponseIterator<Object> {

    ChatAnyResponseBodyIterator() {
    }

    public static ChatAnyResponseBodyIterator create() {
        return new ChatAnyResponseBodyIterator();
    }

    @Override
    protected Object toModel(String data) {
        return ParseUtil.parseJSON(data);
    }

}
