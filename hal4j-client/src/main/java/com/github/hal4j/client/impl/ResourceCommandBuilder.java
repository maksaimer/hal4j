package com.github.hal4j.client.impl;

import com.github.hal4j.client.RequestExecutor;
import com.github.hal4j.client.ResourceCommand;
import com.github.hal4j.resources.HALLink;

public class ResourceCommandBuilder extends ResourceCallBuilder<ResourceCommand> {

    public ResourceCommandBuilder(HALLink link, RequestExecutor client) {
        super(link, client);
    }

    @Override
    ResourceCommand doBuild(RequestExecutor client, HALLink link) {
        return new ResourceCommandImpl(client, link);
    }

}
