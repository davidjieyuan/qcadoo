/**
 * ***************************************************************************
 * Copyright (c) 2010 Qcadoo Limited
 * Project: Qcadoo Framework
 * Version: 0.4.5
 *
 * This file is part of Qcadoo.
 *
 * Qcadoo is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation; either version 3 of the License,
 * or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 * ***************************************************************************
 */
package com.qcadoo.view.internal.menu.module;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.qcadoo.plugin.api.ModuleFactory;
import com.qcadoo.view.internal.api.InternalMenuService;

public class MenuViewModuleFactory extends ModuleFactory<MenuModule> {

    @Autowired
    private InternalMenuService menuService;

    @Override
    protected MenuModule parseElement(final String pluginIdentifier, final Element element) {
        String menuName = getRequiredAttribute(element, "name");
        String menuCategory = getRequiredAttribute(element, "category");
        String menuViewName = getRequiredAttribute(element, "view");

        return new MenuModule(getIdentifier(), menuService, pluginIdentifier, menuName, menuCategory, pluginIdentifier,
                menuViewName, null);
    }

    @Override
    public String getIdentifier() {
        return "menu-item";
    }

}
