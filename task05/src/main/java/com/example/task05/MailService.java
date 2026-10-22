package com.example.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {
    private final Map<String, List<T>> mailBox = new HashMap<>() {
        @Override
        public List<T> get(Object key) {
            if (containsKey(key)) {
                return super.get(key);
            }
            return Collections.emptyList();
        }
    };

    @Override
    public void accept(Sendable<T> message) {
        String recipient = message.getTo();
        if (!mailBox.containsKey(recipient)) {
            mailBox.put(recipient, new ArrayList<>());
        }
        List<T> messages = mailBox.get(recipient);
        messages.add(message.getContent());
    }

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }
}
