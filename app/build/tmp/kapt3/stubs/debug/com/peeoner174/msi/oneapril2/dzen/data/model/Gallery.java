package com.peeoner174.msi.oneapril2.dzen.data.model;

import java.lang.System;

/**
 * Parcelable - \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441 \u0441\u0435\u0440\u0438\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u0438 \u043e\u0431\u044a\u0435\u043a\u0442\u043e\u0432 \u043e\u043f\u0442\u0438\u043c\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439 \u0434\u043b\u044f Android
 */
@android.arch.persistence.room.Entity(tableName = "gallery")
@kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0006H\u00c6\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u00c6\u0001J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u00d6\u0003J\t\u0010\u0018\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0006H\u00d6\u0001J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0013H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\f\u00a8\u0006 "}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "name", "", "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getUrl", "setUrl", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "flags", "Companion", "List", "app_debug"})
public final class Gallery implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    private java.lang.String name;
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.PrimaryKey()
    private java.lang.String url;
    
    /**
     * \u0420\u0435\u0430\u043b\u0438\u0437\u0443\u0435\u0442 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u0435 \u0438\u0437 \u0440\u0430\u043d\u0435\u0435 \u0441\u0435\u0440\u0438\u0430\u043b\u0438\u0437\u043e\u0432\u0430\u043d\u043d\u044b\u0445 \u0434\u0430\u043d\u043d\u044b\u0445 \u0438\u0441\u0445\u043e\u0434\u043d\u044b\u0445 \u043e\u0431\u044a\u0435\u043a\u0442\u043e\u0432 
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.os.Parcelable.Creator<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> CREATOR = null;
    public static final com.peeoner174.msi.oneapril2.dzen.data.model.Gallery.Companion Companion = null;
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    /**
     * \u043f\u0438\u0448\u0435\u0442 \u0432 \u043e\u0431\u044a\u0435\u043a\u0442 Parcel \u0441\u043e\u0434\u0435\u0440\u0436\u0438\u043c\u043e\u0435 \u043e\u0431\u044a\u0435\u043a\u0442\u0430 
     */
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel dest, int flags) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrl() {
        return null;
    }
    
    public final void setUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Gallery(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        super();
    }
    
    public Gallery(@org.jetbrains.annotations.NotNull()
    android.os.Parcel source) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * Parcelable - \u0438\u043d\u0442\u0435\u0440\u0444\u0435\u0439\u0441 \u0441\u0435\u0440\u0438\u0430\u043b\u0438\u0437\u0430\u0446\u0438\u0438 \u043e\u0431\u044a\u0435\u043a\u0442\u043e\u0432 \u043e\u043f\u0442\u0438\u043c\u0438\u0437\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439 \u0434\u043b\u044f Android
     */
    @org.jetbrains.annotations.NotNull()
    public final com.peeoner174.msi.oneapril2.dzen.data.model.Gallery copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery$List;", "Ljava/util/ArrayList;", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "Lkotlin/collections/ArrayList;", "()V", "app_debug"})
    public static final class List extends java.util.ArrayList<com.peeoner174.msi.oneapril2.dzen.data.model.Gallery> {
        
        public List() {
            super(0);
        }
        
        @java.lang.Override()
        public boolean contains(com.peeoner174.msi.oneapril2.dzen.data.model.Gallery p0) {
            return false;
        }
        
        @java.lang.Override()
        public final boolean contains(java.lang.Object p0) {
            return false;
        }
        
        @java.lang.Override()
        public int indexOf(com.peeoner174.msi.oneapril2.dzen.data.model.Gallery p0) {
            return 0;
        }
        
        @java.lang.Override()
        public final int indexOf(java.lang.Object p0) {
            return 0;
        }
        
        @java.lang.Override()
        public int lastIndexOf(com.peeoner174.msi.oneapril2.dzen.data.model.Gallery p0) {
            return 0;
        }
        
        @java.lang.Override()
        public final int lastIndexOf(java.lang.Object p0) {
            return 0;
        }
        
        @java.lang.Override()
        public com.peeoner174.msi.oneapril2.dzen.data.model.Gallery removeAt(int p0) {
            return null;
        }
        
        @java.lang.Override()
        public final com.peeoner174.msi.oneapril2.dzen.data.model.Gallery remove(int p0) {
            return null;
        }
        
        @java.lang.Override()
        public boolean remove(com.peeoner174.msi.oneapril2.dzen.data.model.Gallery p0) {
            return false;
        }
        
        @java.lang.Override()
        public final boolean remove(java.lang.Object p0) {
            return false;
        }
        
        @java.lang.Override()
        public int getSize() {
            return 0;
        }
        
        @java.lang.Override()
        public final int size() {
            return 0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 9}, bv = {1, 0, 2}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/peeoner174/msi/oneapril2/dzen/data/model/Gallery;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}