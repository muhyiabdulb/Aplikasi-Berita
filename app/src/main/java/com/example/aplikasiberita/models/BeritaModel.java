package com.example.aplikasiberita.models;

public class BeritaModel {
    private String title;          // Judul berita
    private String source;         // Nama sumber berita
    private String sourceIcon;     // URL untuk ikon sumber
    private String newsUrl;        // URL berita lengkap

    // Constructor
    public BeritaModel(String title, String source, String sourceIcon, String newsUrl) {
        this.title = title;
        this.source = source;
        this.sourceIcon = sourceIcon;
        this.newsUrl = newsUrl;
    }

    // Getter and Setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceIcon() {
        return sourceIcon;
    }

    public void setSourceIcon(String sourceIcon) {
        this.sourceIcon = sourceIcon;
    }

    public String getNewsUrl() {
        return newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }
}
