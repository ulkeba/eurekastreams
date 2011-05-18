/*
 * Copyright (c) 2010 Lockheed Martin Corporation
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
package org.eurekastreams.web.client.ui.pages.master;

import java.util.List;

import org.eurekastreams.server.domain.Page;
import org.eurekastreams.web.client.ui.ActionExecutorPanel;
import org.eurekastreams.web.client.ui.Session;
import org.eurekastreams.web.client.ui.pages.activity.ActivityContent;
import org.eurekastreams.web.client.ui.pages.help.HelpContent;
import org.eurekastreams.web.client.ui.pages.metrics.MetricsSummaryContent;
import org.eurekastreams.web.client.ui.pages.oauth.OAuthAuthorizeContent;
import org.eurekastreams.web.client.ui.pages.profile.GroupProfilePanel;
import org.eurekastreams.web.client.ui.pages.profile.OrganizationProfilePanel;
import org.eurekastreams.web.client.ui.pages.profile.PersonalProfilePanel;
import org.eurekastreams.web.client.ui.pages.profile.settings.CreateGroupPanel;
import org.eurekastreams.web.client.ui.pages.profile.settings.GroupProfileSettingsPanel;
import org.eurekastreams.web.client.ui.pages.profile.settings.OrganizationProfileSettingsPanel;
import org.eurekastreams.web.client.ui.pages.profile.settings.PersonalProfileSettingsPanel;
import org.eurekastreams.web.client.ui.pages.search.SearchContent;
import org.eurekastreams.web.client.ui.pages.settings.SettingsContent;
import org.eurekastreams.web.client.ui.pages.start.StartPageContent;
import org.eurekastreams.web.client.ui.pages.start.gallery.GalleryContent;
import org.eurekastreams.web.client.ui.pages.stream.StreamContent;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.user.client.AsyncProxy;
import com.google.gwt.user.client.AsyncProxy.ConcreteType;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Creates a page given a page and view.
 * 
 */
public class PageFactory
{
    /**
     * Creates a page given a page and view.
     * 
     * @param page
     *            the page.
     * @param views
     *            the views.
     * @param contentPanel
     *            panel to add page to.
     */
    public void createPage(final Page page, final List<String> views, final FlowPanel contentPanel)
    {
        RootPanel.get().setStyleName("");

        String viewStr = "";
        if (views.size() > 0)
        {
            viewStr = views.get(0);
        }

        final String view = viewStr;

        switch (page)
        {
        case ACTION:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new ActionExecutorPanel(Session.getInstance().getActionProcessor(), view));
                }
            });
            break;
        case SEARCH:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new SearchContent());
                }
            });
            break;
        case SETTINGS:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new SettingsContent(Session.getInstance().getActionProcessor()));
                }
            });
            break;
        case AUTHORIZE:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new OAuthAuthorizeContent(Session.getInstance().getActionProcessor(), view));
                }
            });
            break;
        case GALLERY:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new GalleryContent());
                }
            });            
            break;
        case ACTIVITY:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new StreamContent());
                }
            });
            break;
        case ACTIVITY_NEW:
            contentPanel.add(new ActivityContent());
            break;
        case PEOPLE:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new PersonalProfilePanel(view));
                }
            });               
            break;
        case PERSONAL_SETTINGS:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new PersonalProfileSettingsPanel());
                }
            });                
            break;
        case GROUPS:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new GroupProfilePanel(view));
                }
            });               
            break;
        case GROUP_SETTINGS:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new GroupProfileSettingsPanel(view));
                }
            });                  
            break;
        case NEW_GROUP:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new CreateGroupPanel(view));
                }
            });              
            break;
        case HELP:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new HelpContent());
                }
            });               
            break;
        case METRICS:
            GWT.runAsync(new RunAsyncCallback()
            {
                public void onFailure(Throwable reason)
                {
                }

                public void onSuccess()
                {
                    contentPanel.add(new MetricsSummaryContent());
                }
            });
            break;
        default:
            contentPanel.add(new StartPageContent());
            break;
        }

    }
}
