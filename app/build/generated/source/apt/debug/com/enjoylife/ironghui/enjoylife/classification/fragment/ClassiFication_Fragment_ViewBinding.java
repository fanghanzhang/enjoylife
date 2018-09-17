// Generated code from Butter Knife. Do not modify!
package com.enjoylife.ironghui.enjoylife.classification.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.enjoylife.ironghui.enjoylife.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ClassiFication_Fragment_ViewBinding<T extends ClassiFication_Fragment> implements Unbinder {
  protected T target;

  @UiThread
  public ClassiFication_Fragment_ViewBinding(T target, View source) {
    this.target = target;

    target.lvMenu = Utils.findRequiredViewAsType(source, R.id.lv_menu, "field 'lvMenu'", ListView.class);
    target.lvHome = Utils.findRequiredViewAsType(source, R.id.lv_home, "field 'lvHome'", ListView.class);
    target.tvTitile = Utils.findRequiredViewAsType(source, R.id.tv_titile, "field 'tvTitile'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.lvMenu = null;
    target.lvHome = null;
    target.tvTitile = null;

    this.target = null;
  }
}
