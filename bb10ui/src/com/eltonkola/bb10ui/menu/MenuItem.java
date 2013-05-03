package com.eltonkola.bb10ui.menu;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.SubMenu;
import android.view.View;



/**
 * CustomMenuItem class
 *
 * This is class basically a container for you menu items.
 *
 * @category   Helper
 * @author     William J Francis (w.j.francis@tx.rr.com)
 * @copyright  Enjoy!
 * @version    1.0
 */
public class MenuItem implements android.view.MenuItem{
	
	//min data i need
	
	private String mCaption = null;
	private int mImageResourceId = -1;
	private int mId = -1;

	public void setCaption(String caption) { mCaption =caption;	}
	public String getCaption() { return mCaption; }
	public void setImageResourceId(int imageResourceId) { mImageResourceId = imageResourceId; }
	public int getImageResourceId() { return mImageResourceId;	}
	public void setId(int id) { mId = id; }
	public int getId() { return mId; }
	
	
	//stuff i need for normal interfacing
	@Override
	public int getItemId() {
		return mId;
	}
	
	//all other stuff i will nto use
	
	@Override
	public boolean collapseActionView() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean expandActionView() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ActionProvider getActionProvider() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public View getActionView() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public char getAlphabeticShortcut() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getGroupId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Drawable getIcon() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Intent getIntent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContextMenuInfo getMenuInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public char getNumericShortcut() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public SubMenu getSubMenu() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CharSequence getTitle() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public CharSequence getTitleCondensed() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasSubMenu() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isActionViewExpanded() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isCheckable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isChecked() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public android.view.MenuItem setActionProvider(ActionProvider actionProvider) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setActionView(View view) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setActionView(int resId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setAlphabeticShortcut(char alphaChar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setCheckable(boolean checkable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setChecked(boolean checked) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setEnabled(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setIcon(Drawable icon) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setIcon(int iconRes) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setIntent(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setNumericShortcut(char numericChar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setOnActionExpandListener(
			OnActionExpandListener listener) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setOnMenuItemClickListener(
			OnMenuItemClickListener menuItemClickListener) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setShortcut(char numericChar, char alphaChar) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setShowAsAction(int actionEnum) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public android.view.MenuItem setShowAsActionFlags(int actionEnum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setTitle(CharSequence title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setTitle(int title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setTitleCondensed(CharSequence title) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public android.view.MenuItem setVisible(boolean visible) {
		// TODO Auto-generated method stub
		return null;
	}
	
	///all the stuff android needs
	
	
}
