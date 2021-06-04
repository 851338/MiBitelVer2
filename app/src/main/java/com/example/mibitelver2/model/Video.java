package com.example.mibitelver2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

public class Video {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("category_id")
    @Expose
    String category_id;

    @SerializedName("provider_id")
    @Expose
    private String provider_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("avatar")
    @Expose
    private String avatar;

    @SerializedName("price")
    @Expose
    private float price;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("deleted")
    @Expose
    private int deleted;

    @SerializedName("copyright")
    @Expose
    private int copyright;

    @SerializedName("artist_name")
    @Expose
    private String artist_name;

    @SerializedName("album_name")
    @Expose
    private String album_name;

    @SerializedName("file_3gp")
    @Expose
    private String file_3gp;

    @SerializedName("file_mp4_size")
    @Expose
    long file_mp4_size;

    @SerializedName("file_3gp_size")
    @Expose
    long file_3gp_size;

    @SerializedName("total_downloaded")
    @Expose
    private String total_downloaded;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("date_created")
    @Expose
    private String date_modified;

    @SerializedName("date_published")
    @Expose
    private String date_published;

    @SerializedName("user_created")
    @Expose
    private String user_created;

    @SerializedName("user_modified")
    @Expose
    private String user_modified;

    @SerializedName("convert_status")
    @Expose
    private String convert_status;

    @SerializedName("convert_time")
    @Expose
    private String convert_time;

    @SerializedName("youtube_url")
    @Expose
    private String youtube_url;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("download_status")
    @Expose
    private String download_status;

    @SerializedName("fb_download")
    @Expose
    private String fb_download;

    @SerializedName("icash")
    @Expose
    private String icash;

    @SerializedName("fb_url")
    @Expose
    private String fb_url;

    @SerializedName("aws_status")
    @Expose
    private String aws_status;

    @SerializedName("icash_2")
    @Expose
    private String icash_2;

    @SerializedName("price_2")
    @Expose
    private String price_2;

    @SerializedName("publisher_category_id")
    @Expose
    private String publisher_category_id;

    @SerializedName("view_clip_gold")
    @Expose
    private String view_clip_icash;

    @SerializedName("download_clip_gold")
    @Expose
    private String download_clip_gold;

    @SerializedName("download_clip_icash")
    @Expose
    private String download_clip_icash;

    @SerializedName("file_mp4")
    @Expose
    String file_mp4;

    public Video() {

    }

    public Video(String id, String category_id, String provider_id, String title, String avatar,
                 float price, String status, int deleted, int copyright, String artist_name,
                 String album_name, String file_3gp, long file_mp4_size, long file_3gp_size,
                 String total_downloaded, String description, String duration, String date_modified,
                 String date_published, String user_created, String user_modified,
                 String convert_status, String convert_time, String youtube_url, String tags,
                 String download_status, String fb_download, String icash, String fb_url,
                 String aws_status, String icash_2, String price_2, String publisher_category_id,
                 String view_clip_icash, String download_clip_gold, String download_clip_icash,
                 String file_mp4) {
        this.id = id;
        this.category_id = category_id;
        this.provider_id = provider_id;
        this.title = title;
        this.avatar = avatar;
        this.price = price;
        this.status = status;
        this.deleted = deleted;
        this.copyright = copyright;
        this.artist_name = artist_name;
        this.album_name = album_name;
        this.file_3gp = file_3gp;
        this.file_mp4_size = file_mp4_size;
        this.file_3gp_size = file_3gp_size;
        this.total_downloaded = total_downloaded;
        this.description = description;
        this.duration = duration;
        this.date_modified = date_modified;
        this.date_published = date_published;
        this.user_created = user_created;
        this.user_modified = user_modified;
        this.convert_status = convert_status;
        this.convert_time = convert_time;
        this.youtube_url = youtube_url;
        this.tags = tags;
        this.download_status = download_status;
        this.fb_download = fb_download;
        this.icash = icash;
        this.fb_url = fb_url;
        this.aws_status = aws_status;
        this.icash_2 = icash_2;
        this.price_2 = price_2;
        this.publisher_category_id = publisher_category_id;
        this.view_clip_icash = view_clip_icash;
        this.download_clip_gold = download_clip_gold;
        this.download_clip_icash = download_clip_icash;
        this.file_mp4 = file_mp4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFile_mp4() {
        return file_mp4;
    }

    public void setFile_mp4(String file_mp4) {
        this.file_mp4 = file_mp4;
    }

    public String getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public String getFile_3gp() {
        return file_3gp;
    }

    public void setFile_3gp(String file_3gp) {
        this.file_3gp = file_3gp;
    }

    public long getFile_mp4_size() {
        return file_mp4_size;
    }

    public void setFile_mp4_size(long file_mp4_size) {
        this.file_mp4_size = file_mp4_size;
    }

    public long getFile_3gp_size() {
        return file_3gp_size;
    }

    public void setFile_3gp_size(long file_3gp_size) {
        this.file_3gp_size = file_3gp_size;
    }

    public String getTotal_downloaded() {
        return total_downloaded;
    }

    public void setTotal_downloaded(String total_downloaded) {
        this.total_downloaded = total_downloaded;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDate_modified() {
        return date_modified;
    }

    public void setDate_modified(String date_modified) {
        this.date_modified = date_modified;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getUser_created() {
        return user_created;
    }

    public void setUser_created(String user_created) {
        this.user_created = user_created;
    }

    public String getUser_modified() {
        return user_modified;
    }

    public void setUser_modified(String user_modified) {
        this.user_modified = user_modified;
    }

    public String getConvert_status() {
        return convert_status;
    }

    public void setConvert_status(String convert_status) {
        this.convert_status = convert_status;
    }

    public String getConvert_time() {
        return convert_time;
    }

    public void setConvert_time(String convert_time) {
        this.convert_time = convert_time;
    }

    public String getYoutube_url() {
        return youtube_url;
    }

    public void setYoutube_url(String youtube_url) {
        this.youtube_url = youtube_url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDownload_status() {
        return download_status;
    }

    public void setDownload_status(String download_status) {
        this.download_status = download_status;
    }

    public String getFb_download() {
        return fb_download;
    }

    public void setFb_download(String fb_download) {
        this.fb_download = fb_download;
    }

    public String getIcash() {
        return icash;
    }

    public void setIcash(String icash) {
        this.icash = icash;
    }

    public String getFb_url() {
        return fb_url;
    }

    public void setFb_url(String fb_url) {
        this.fb_url = fb_url;
    }

    public String getAws_status() {
        return aws_status;
    }

    public void setAws_status(String aws_status) {
        this.aws_status = aws_status;
    }

    public String getIcash_2() {
        return icash_2;
    }

    public void setIcash_2(String icash_2) {
        this.icash_2 = icash_2;
    }

    public String getPrice_2() {
        return price_2;
    }

    public void setPrice_2(String price_2) {
        this.price_2 = price_2;
    }

    public String getPublisher_category_id() {
        return publisher_category_id;
    }

    public void setPublisher_category_id(String publisher_category_id) {
        this.publisher_category_id = publisher_category_id;
    }

    public String getView_clip_icash() {
        return view_clip_icash;
    }

    public void setView_clip_icash(String view_clip_icash) {
        this.view_clip_icash = view_clip_icash;
    }

    public String getDownload_clip_gold() {
        return download_clip_gold;
    }

    public void setDownload_clip_gold(String download_clip_gold) {
        this.download_clip_gold = download_clip_gold;
    }

    public String getDownload_clip_icash() {
        return download_clip_icash;
    }

    public void setDownload_clip_icash(String download_clip_icash) {
        this.download_clip_icash = download_clip_icash;
    }
}
