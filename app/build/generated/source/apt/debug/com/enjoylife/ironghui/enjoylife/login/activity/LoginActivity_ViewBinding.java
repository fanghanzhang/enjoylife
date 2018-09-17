// Generated code from Butter Knife. Do not modify!
package com.enjoylife.ironghui.enjoylife.login.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.enjoylife.ironghui.enjoylife.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginActivity_ViewBinding<T extends LoginActivity> implements Unbinder {
  protected T target;

  private View view2131230845;

  @UiThread
  public LoginActivity_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.etPhonenum = Utils.findRequiredViewAsType(source, R.id.et_phonenum, "field 'etPhonenum'", EditText.class);
    view = Utils.findRequiredView(source, R.id.loginbutton, "field 'loginbutton' and method 'onViewClicked'");
    target.loginbutton = Utils.castView(view, R.id.loginbutton, "field 'loginbutton'", Button.class);
    view2131230845 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
    target.tvDeal = Utils.findRequiredViewAsType(source, R.id.tv_deal, "field 'tvDeal'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.etPhonenum = null;
    target.loginbutton = null;
    target.tvDeal = null;

    view2131230845.setOnClickListener(null);
    view2131230845 = null;

    this.target = null;
  }
}
