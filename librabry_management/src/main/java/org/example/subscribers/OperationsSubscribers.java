package org.example.subscribers;

import org.example.author.Author;

import java.util.List;
import java.util.concurrent.Flow;

public interface OperationsSubscribers {
    List<User> getAllSubscribers();

    List<User> saveAllSubscribers(List<User> users);
    User saveSubscribers(User toSave);
    User deleteSubscribers(User toDelete);
}
