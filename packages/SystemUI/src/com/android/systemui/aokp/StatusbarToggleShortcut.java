/*
 * Copyright 2011 AOKP by Mike Wilson - Zaphod-Beeblebrox
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

package com.android.systemui.aokp;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;

/*
 * Toggle the StatusBar
 */

public class StatusbarToggleShortcut extends Activity  {
  public StatusbarToggleShortcut() {
    super();
  }

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onResume()  {
    super.onResume();
    boolean StatusbarState = Settings.System.getBoolean(getContentResolver(),
        Settings.System.STATUSBAR_HIDDEN_NOW, false);
    Settings.System.putBoolean(getContentResolver(),
        Settings.System.STATUSBAR_HIDDEN_NOW, !StatusbarState);
    // always reset if global config changes
    Settings.System.putBoolean(getContentResolver(),
        Settings.System.STATUSBAR_SHOW_HIDDEN_WITH_SWIPE, false);
    this.finish();
  }
}
