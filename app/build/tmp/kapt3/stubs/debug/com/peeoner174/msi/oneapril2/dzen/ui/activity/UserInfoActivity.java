package com.peeoner174.msi.oneapril2.dzen.ui.activity;

import java.lang.System;

/**
 * \u042d\u043a\u0440\u0430\u043d \u0441 \u0438\u043d\u0444\u043e\u0440\u043c\u0430\u0446\u0438\u0435\u0439 \u043e \u043f\u043e\u043b\u044c\u0437\u043e\u0432\u0430\u0442\u0435\u043b\u0435
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J$\u0010\u001e\u001a\u00020\u00172\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0 H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/UserInfoActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "adapter", "Lcom/peeoner174/msi/oneapril2/dzen/ui/adapter/RecViewTripAdapter;", "dataLoader", "Lcom/peeoner174/msi/oneapril2/dzen/producer/TripDataLoaderWeb;", "dataLoaderUserInfo", "Lcom/peeoner174/msi/oneapril2/dzen/producer/UserInfoLoad;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "mOnNavigationItemSelectedListener", "Landroid/support/design/widget/BottomNavigationView$OnNavigationItemSelectedListener;", "userId", "Lcom/peeoner174/msi/oneapril2/MySingleton;", "kotlin.jvm.PlatformType", "userViewPagerAdapter", "Lcom/peeoner174/msi/oneapril2/dzen/ui/adapter/UserViewPagerAdapter;", "user_photo", "Landroid/widget/ImageView;", "viewPager", "Landroid/support/v4/view/ViewPager;", "initRecyclerView", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setViewPager", "showUsers", "trips", "", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Trip;", "users", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/User;", "app_debug"})
public final class UserInfoActivity extends android.support.v7.app.AppCompatActivity {
    private com.peeoner174.msi.oneapril2.dzen.ui.adapter.RecViewTripAdapter adapter;
    private final android.support.v7.widget.RecyclerView.LayoutManager layoutManager = null;
    private final com.peeoner174.msi.oneapril2.dzen.producer.TripDataLoaderWeb dataLoader = null;
    private final com.peeoner174.msi.oneapril2.dzen.producer.UserInfoLoad dataLoaderUserInfo = null;
    private android.support.v4.view.ViewPager viewPager;
    private com.peeoner174.msi.oneapril2.dzen.ui.adapter.UserViewPagerAdapter userViewPagerAdapter;
    private android.widget.ImageView user_photo;
    private final com.peeoner174.msi.oneapril2.MySingleton userId = null;
    private final android.support.design.widget.BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showUsers(java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.Trip> trips, java.util.List<com.peeoner174.msi.oneapril2.dzen.data.model.User> users) {
    }
    
    private final void setViewPager() {
    }
    
    private final void initRecyclerView(android.support.v7.widget.RecyclerView recyclerView) {
    }
    
    public UserInfoActivity() {
        super();
    }
}