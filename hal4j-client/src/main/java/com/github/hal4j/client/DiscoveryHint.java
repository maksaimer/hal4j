package com.github.hal4j.client;

import com.github.hal4j.resources.HALLink;

import java.util.function.Predicate;
import java.util.stream.Stream;

public interface DiscoveryHint extends Predicate<HALLink> {

    static Predicate<? super HALLink> matchingAll(DiscoveryHint[] hints) {
        return link -> Stream.of(hints).allMatch(hint -> hint.test(link));
    }

    static DiscoveryHint name(String name) {
        if (name == null) {
            return link -> link.name == null;
        }
        return link -> link.name != null && link.name.equals(name);
    }

}
