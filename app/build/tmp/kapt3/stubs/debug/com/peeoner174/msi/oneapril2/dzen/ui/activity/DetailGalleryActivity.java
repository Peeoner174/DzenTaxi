package com.peeoner174.msi.oneapril2.dzen.ui.activity;

import java.lang.System;

/**
 * \u0410\u043a\u0442\u0438\u0432\u0438\u0442\u0438 \u0433\u0430\u043b\u0435\u0440\u0435\u0438 (\u043a\u043e\u0433\u0434\u0430 \u043f\u0440\u0438\u0431\u043b\u0438\u0436\u0430\u044e\u0442 \u0438\u0437\u043e\u0431\u0440\u0430\u0436\u0435\u043d\u0438\u0435 \u0438 \u0441\u043c\u043e\u0442\u0440\u044f\u0442 \u043f\u043e \u043e\u0434\u043d\u043e\u0439 \u0444\u043e\u0442\u043e)
 */
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0018\u00010\u0007R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "data", "Ljava/util/ArrayList;", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "mSectionsPagerAdapter", "Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity$SectionsPagerAdapter;", "mViewPager", "Landroid/support/v4/view/ViewPager;", "pos", "", "initViewPager", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "", "menu", "Landroid/view/Menu;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "PlaceholderFragment", "SectionsPagerAdapter", "app_debug"})
public final class DetailGalleryActivity extends android.support.v7.app.AppCompatActivity {
    private com.peeoner174.msi.oneapril2.dzen.ui.activity.DetailGalleryActivity.SectionsPagerAdapter mSectionsPagerAdapter;
    private java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> data;
    private int pos;
    private android.support.v4.view.ViewPager mViewPager;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void initViewPager() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    public DetailGalleryActivity() {
        super();
    }
    
    /**
     * [FragmentPagerAdapter] - \u0432\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u0444\u0440\u0430\u0433\u043c\u0435\u043d\u0442 \u0441\u043e\u043e\u0442\u0432\u0435\u0442\u0441\u0442\u0432\u0443\u044e\u0449\u0438\u0439 \u043f\u043e\u0437\u0438\u0446\u0438\u0438
     */
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\rH\u0016J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0010\u001a\u00020\rH\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity$SectionsPagerAdapter;", "Landroid/support/v4/app/FragmentStatePagerAdapter;", "fm", "Landroid/support/v4/app/FragmentManager;", "data", "Ljava/util/ArrayList;", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "(Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity;Landroid/support/v4/app/FragmentManager;Ljava/util/ArrayList;)V", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getCount", "", "getItem", "Landroid/support/v4/app/Fragment;", "position", "getPageTitle", "", "app_debug"})
    public final class SectionsPagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter {
        @org.jetbrains.annotations.NotNull()
        private java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> data;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> getData() {
            return null;
        }
        
        public final void setData(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.app.Fragment getItem(int position) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public java.lang.CharSequence getPageTitle(int position) {
            return null;
        }
        
        public SectionsPagerAdapter(@org.jetbrains.annotations.NotNull()
        android.support.v4.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> data) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u000fH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity$PlaceholderFragment;", "Landroid/support/v4/app/Fragment;", "()V", "name", "", "pos", "", "url", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "setArguments", "args", "Companion", "app_debug"})
    public static final class PlaceholderFragment extends android.support.v4.app.Fragment {
        private java.lang.String name;
        private java.lang.String url;
        private int pos;
        private static final java.lang.String ARG_SECTION_NUMBER = "section_number";
        private static final java.lang.String ARG_IMG_TITLE = "image_title";
        private static final java.lang.String ARG_IMG_URL = "image_url";
        public static final com.peeoner174.msi.oneapril2.dzen.ui.activity.DetailGalleryActivity.PlaceholderFragment.Companion Companion = null;
        private java.util.HashMap _$_findViewCache;
        
        @java.lang.Override()
        public void setArguments(@org.jetbrains.annotations.Nullable()
        android.os.Bundle args) {
        }
        
        @java.lang.Override()
        public void onStart() {
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
        android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
        android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
        android.os.Bundle savedInstanceState) {
            return null;
        }
        
        public PlaceholderFragment() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity$PlaceholderFragment$Companion;", "", "()V", "ARG_IMG_TITLE", "", "getARG_IMG_TITLE", "()Ljava/lang/String;", "ARG_IMG_URL", "getARG_IMG_URL", "ARG_SECTION_NUMBER", "getARG_SECTION_NUMBER", "newInstance", "Lcom/peeoner174/msi/oneapril2/dzen/ui/activity/DetailGalleryActivity$PlaceholderFragment;", "sectionNumber", "", "name", "url", "app_debug"})
        public static final class Companion {
            
            private final java.lang.String getARG_SECTION_NUMBER() {
                return null;
            }
            
            private final java.lang.String getARG_IMG_TITLE() {
                return null;
            }
            
            private final java.lang.String getARG_IMG_URL() {
                return null;
            }
            
            /**
             * * \u0412\u043e\u0437\u0432\u0440\u0430\u0449\u0430\u0435\u0442 \u0438\u043d\u0441\u0442\u0430\u043d\u0441 \u0444\u0440\u0430\u0433\u043c\u0435\u043d\u0442\u0430 \u0443\u043a\u0430\u0437\u0430\u043d\u043d\u043e\u0439 \u043f\u043e\u0437\u0438\u0446\u0438\u0438
             */
            @org.jetbrains.annotations.NotNull()
            public final com.peeoner174.msi.oneapril2.dzen.ui.activity.DetailGalleryActivity.PlaceholderFragment newInstance(int sectionNumber, @org.jetbrains.annotations.NotNull()
            java.lang.String name, @org.jetbrains.annotations.NotNull()
            java.lang.String url) {
                return null;
            }
            
            private Companion() {
                super();
            }
        }
    }
}