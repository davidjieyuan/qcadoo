package com.qcadoo.plugin.api;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PluginUtil {

    @Autowired
    private PluginStateResolver pluginStateResolver;

    private static PluginUtil instance;

    @PostConstruct
    public void init() {
        initialise(this);
    }

    private static void initialise(final PluginUtil pluginUtil) {
        PluginUtil.instance = pluginUtil;
    }

    public static boolean isEnabled(final Plugin plugin) {
        return instance.pluginStateResolver.isEnabled(plugin);
    }

    public static boolean isEnabled(final String pluginIdentifier) {
        return instance.pluginStateResolver.isEnabled(pluginIdentifier);
    }

}
