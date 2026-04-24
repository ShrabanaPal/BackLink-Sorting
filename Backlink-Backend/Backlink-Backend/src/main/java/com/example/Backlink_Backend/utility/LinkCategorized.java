package com.example.Backlink_Backend.utility;

public class LinkCategorized {
    public static String categorize(String url){

        url = url.toLowerCase()
                .replace("https://", "")
                .replace("http://", "")
                .replace("www.", "");

        if (url.contains("facebook") || url.contains("instagram") ||
                url.contains("twitter") || url.contains("linkedin")) {
            return "SOCIAL_MEDIA";
        }

        if (url.contains("edu") || url.contains("coursera") ||
                url.contains("udemy") || url.contains("wikipedia") || url.contains("github") ||
                url.contains("reddit") || url.contains("pinterest") || url.contains("youtube")) {
            return "EDUCATIONAL";
        }

        if (url.contains("amazon") || url.contains("flipkart") ||
                url.contains("messho") || url.contains("myntra")) {
            return "ECOMMERCE";
        }

        if (url.contains("tools") || url.contains("calculator") ||
                url.contains("convert") || url.contains("maps")) {
            return "TOOLS";
        }

        if (url.contains("tesla") || url.contains("hyundai") ||
                url.contains("tata") || url.contains("samsung")) {
            return "CAR_WEBSITE";
        }
        if (url.contains("apple") || url.contains("xiaomi") ||
                url.contains("google-pixel") || url.contains("samsung-phone")) {
            return "PHONE_WEBSITE";
        }
        else{
            return "Others";
        }
    }
    public static boolean isvalid(String url){
        return url != null &&
                (url.startsWith("http://") || url.startsWith("https://"));
    }
}
