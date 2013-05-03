package com.eltonkola.bb10ui.slide;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import com.eltonkola.bb10ui.R;
import com.eltonkola.bb10ui.slide.SlideMenuEvents.OnSlideMenuItemClickListener;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * View of displaying side navigation.
 * 
 * @author e.shishkin
 * 
 */
public class RightSlideView extends LinearLayout {
    private static final String LOG_TAG = RightSlideView.class.getSimpleName();

    private LinearLayout navigationMenu;
    private ListView listView;
    private View outsideView;

    private OnSlideMenuItemClickListener callback;
    private ArrayList<BB10SlideMenuItem> menuItems;


    /**
     * Constructor of {@link RightSlideView}.
     * 
     * @param context
     */
    public RightSlideView(Context context) {
        super(context);
        load();
    }

    /**
     * Constructor of {@link RightSlideView}.
     * 
     * @param context
     * @param attrs
     */
    public RightSlideView(Context context, AttributeSet attrs) {
        super(context, attrs);
        load();
    }

    /**
     * Loading of side navigation view.
     */
    private void load() {
        if (isInEditMode()) {
            return;
        }
        initView();
    }

    /**
     * Initialization layout of side menu.
     */
    private void initView() {
        removeAllViews();
        int sideNavigationRes = R.layout.slide_right;

        LayoutInflater.from(getContext()).inflate(sideNavigationRes, this, true);
        navigationMenu = (LinearLayout) findViewById(R.id.side_navigation_menu);
        listView = (ListView) findViewById(R.id.side_navigation_listview);
        outsideView = (View) findViewById(R.id.side_navigation_outside_view);
        outsideView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                hideMenu();
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (callback != null) {
                    callback.onSlideMenuItemClick(menuItems.get(position).getId());
                }
                hideMenu();
            }
        });
    }

    /**
     * Setup of {@link ISideNavigationCallback} for callback of item click.
     * 
     * @param callback
     */
    public void setMenuClickCallback(OnSlideMenuItemClickListener callback) {
        this.callback = callback;
    }

    /**
     * Setup of side menu items.
     * 
     * @param menu - resource ID
     */
    public void setMenuItems(int menu) {
        parseXml(menu);
        if (menuItems != null && menuItems.size() > 0) {
            listView.setAdapter(new BB10SlideMenuItemAdapter( getContext() , menuItems, -1));
        }
    }
    
    public void setMenuItems(ArrayList<BB10SlideMenuItem> menuList) {
        this.menuItems=menuList;
    	if (menuItems != null && menuItems.size() > 0) {
            listView.setAdapter(new BB10SlideMenuItemAdapter( getContext() , menuItems, -1));
        }
    }

    /**
	 * 
	 */
    public void setBackgroundResource(int resource) {
        listView.setBackgroundResource(resource);
    }

    /**
     * Show side navigation menu.
     */
    public void showMenu() {
        outsideView.setVisibility(View.VISIBLE);
        outsideView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.side_navigation_fade_in));
        // show navigation menu with animation
        int animRes = R.anim.side_navigation_in_from_right;

        navigationMenu.setVisibility(View.VISIBLE);
        navigationMenu.startAnimation(AnimationUtils.loadAnimation(getContext(), animRes));
    }

    /**
     * Hide side navigation menu.
     */
    public void hideMenu() {
        outsideView.setVisibility(View.GONE);
        outsideView.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.side_navigation_fade_out));
        // hide navigation menu with animation
        int animRes = R.anim.side_navigation_out_to_right;
        navigationMenu.setVisibility(View.GONE);
        navigationMenu.startAnimation(AnimationUtils.loadAnimation(getContext(), animRes));
    }

    /**
     * Show/Hide side navigation menu depending on visibility.
     */
    public void toggleMenu() {
        if (isShown()) {
            hideMenu();
        } else {
            showMenu();
        }
    }

    @Override
    public boolean isShown() {
        return navigationMenu.isShown();
    }

    /**
     * Parse XML describe menu.
     * 
     * @param menu - resource ID
     */
    private void parseXml(int menu) {
        menuItems = new ArrayList<BB10SlideMenuItem>();
        try {
            XmlResourceParser xrp = getResources().getXml(menu);
            xrp.next();
            int eventType = xrp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {
                    String elemName = xrp.getName();
                    if (elemName.equals("item")) {
                        String textId = xrp.getAttributeValue(
                                "http://schemas.android.com/apk/res/android",
                                "title");
                        String iconId = xrp.getAttributeValue(
                                "http://schemas.android.com/apk/res/android",
                                "icon");
                        String resId = xrp.getAttributeValue(
                                "http://schemas.android.com/apk/res/android",
                                "id");
                        BB10SlideMenuItem item = new BB10SlideMenuItem();
                        item.setId(Integer.valueOf(resId.replace("@", "")));
                        item.setName(resourceIdToString(textId));
                        if (iconId != null) {
                            try {
                                item.setIcon(Integer.valueOf(iconId.replace("@", "")));
                            } catch (NumberFormatException e) {
                                Log.d(LOG_TAG, "Item " + item.getId() + " not have icon");
                            }
                        }
                        menuItems.add(item);
                    }
                }
                eventType = xrp.next();
            }
        } catch (Exception e) {
            Log.w(LOG_TAG, e);
        }
    }

    /**
     * Convert resource ID to String.
     * 
     * @param text
     * @return
     */
    private String resourceIdToString(String resId) {
        if (!resId.contains("@")) {
            return resId;
        } else {
            String id = resId.replace("@", "");
            return getResources().getString(Integer.valueOf(id));
        }
    }
}