package com.testdb;

import com.ursusarctos.db.JNIDatamanager;
import com.facebook.react.ReactActivity;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.ReactInstanceManager;


public class MainActivity extends ReactActivity implements ReactInstanceManager.ReactInstanceEventListener {

  @Override
  public void onResume() {
    super.onResume();
    getReactInstanceManager().addReactInstanceEventListener(this);
  }

  @Override
  public void onPause() {
    super.onPause();
    getReactInstanceManager().removeReactInstanceEventListener(this);
  }

  @Override
  public void onReactContextInitialized(ReactContext context) {
    new JNIDatamanager().installBinding(context.getJavaScriptContextHolder().get());
  }


  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "testDB";
  }
}
