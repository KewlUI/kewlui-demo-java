package com.gofintec.app.ui;

/*
MIT License

Copyright (c) 2024 GoFintec Ltd

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

// Please note that Java and Javascript libraries linked in may have different licenses
// some guidance is under KewlUI-License.txt


import com.gofintec.app.ui.TestApp.Forms.DashboardForm;
import com.gofintec.app.ui.TestApp.Forms.RouterForm;
import com.gofintec.kewlui.KewlUI;
import com.gofintec.kewlui.messages.LoadComponentMsg;
import com.gofintec.kewlui.web.api.ComponentGetterAllow;
import com.gofintec.kewlui.web.api.ResourceGetter;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.net.SocketException;



/**
 * Main Spring application class for KewlUI
 * This registers the main GET/POST endpoints under /kewlui path
 * On requesting a new connection, callbacks will be fired to allow the local code to provide its own checks etc
 */

// Excludes DataSourceAutoConfiguration to avoid auto-configuring a database connection.
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(
		// Scans specific base packages for Spring components, using fully qualified names for bean naming.
		basePackages = {"com.gofintec.kewlui.web.base", "com.gofintec.kewlui.web.api" , "com.gofintec.kewlui.web.configuration"},
		nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class KewlUiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(KewlUiDemoApplication.class, args);
	}

	@PostConstruct
	public void init() throws SocketException {
	}

	private static KewlUI ui = new KewlUI(new DefaultResourceLoader());
	private static DashboardForm dashboardWindow = new DashboardForm();



	/**
	 * Defined here to register the functionality under kewlUI
	 * use the component factory to set builders for various pages
	 * @return KewlUI instance
	 */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public KewlUI kewlUI () {

		// wildcard, all pages are directed here, and the builder is used to construct the dashboard etc
		ui.getComponentFactory().setBuilder("*",
				(pageType, optionalVariantInfo)-> dashboardWindow.createDashboardPage(pageType,optionalVariantInfo),
				(request)-> dashboardWindow.userPageRequest(request)
		);

		// called when we don't know who this user/session is
		// return false if we do not allow this
		ui.setNewSessionValidation((sessionInfo -> {
			var autToken = sessionInfo.getAuthorization();
			// ... here add in if check if auth token is valid
			return true;
		}));
		ui.start(); // start KewlUI - locally available under http://localhost:8080/kewlui/index.html

		return ui;
	}


	/**
	 * If this function is defined, it is called by KewlUI when someone does a GET request on /kewlui
	 * @return a resource, or NULL if not allowed
	 */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ResourceGetter resourceGetter () {
		return new ResourceGetter() {
			@Override
			public Resource getResource(ResourceLoader loader, String filePath, HttpServletRequest request) {
				return loader.getResource("classpath:static/" + filePath);
			}
		};
	}

	/**
	 * If this function is defined, it will be called when someone is requesting a control/form on /kewlui
	 * Return false if your wish to quickly disallow it
	 *
	 * Note - permission to see form  is also checked via a function passed into the builder
	 * e.g. in the form control - public static ControlRequestReply userPageRequest (ControlRequestEvent requestEvent)
	 *
	 * However, this simple true/false function is provided as a convenience
	 *
	 * @return true if allowed, false if not
	 */
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ComponentGetterAllow allowComponentGet () {
		return new ComponentGetterAllow() {
			@Override
			public boolean allow(LoadComponentMsg loadComponentMsg, HttpServletRequest request) {
				return true; // allow by default
			}
		};
	}

}
