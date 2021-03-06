/*
 * Copyright 2015 the original author or authors.
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
 *
 *
 */

package org.springframework.xd.dirt.modules.metadata;

import org.springframework.xd.module.options.spi.ModuleOption;
import org.springframework.xd.module.options.spi.ProfileNamesProvider;

/**
 * A mixin that can be used every time a module dealing with Files offers
 * the choice to pass along the File itself or its contents.
 *
 * @author Eric Bottard
 */
public class FileAsRefMixin implements ProfileNamesProvider {

	private static final String USE_REF = "use-ref";

	private static final String USE_CONTENT = "use-contents";

	private boolean ref = false;


	public boolean isRef() {
		return ref;
	}

	@ModuleOption("set to true to output the File object itself")
	public void setRef(boolean ref) {
		this.ref = ref;
	}

	@Override
	public String[] profilesToActivate() {
		return ref ? new String[] { USE_REF } : new String[] { USE_CONTENT };
	}
}
