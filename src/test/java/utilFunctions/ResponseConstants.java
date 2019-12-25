package utilFunctions;


import java.util.HashMap;
import java.util.Map;

public class ResponseConstants {
    public Map<String, String> responseStatus() {
        Map<String, String> response = new HashMap<>();
        response.put("1", "SUCCESS");
        response.put("2", "API_KEY_NOT_FOUND");
        response.put("3", "API_KEY_NOT_MATCHING");
        response.put("4", "AUTH_TOKEN_NOT_FOUND");
        response.put("5", "AUTH_TOKEN_NOT_MATCHING");
        response.put("6", "DATA_NOT_FOUND_IN_REQUEST");
        response.put("7", "MUST_BE_NUMBER");
        response.put("8", "LESS_THAN_ZERO");
        response.put("9", "INCORRECT_CREDENTIALS");
        response.put("10", "INTERNAL_SERVER_ERROR");
        response.put("11", "DATA_EXIST");
        response.put("12", "DATA_NOT_FOUND");
        response.put("13", "USER_STATUS_PENDING_OR_REJECTED");
        response.put("14", "USER_INACTIVE");
        response.put("15", "PLAYER_NOT_FOUND");
        response.put("16", "INSERTION_FLAG_NOT_FOUND");
        response.put("17", "INVALID_DATA");
        response.put("18", "MINIMUM_GREATER_MAXIMUM");
        response.put("19", "BETTING_BUTTON_BETWEEN_0_100");
        response.put("20", "INVALID_FLAG");
        response.put("21", "BB_LESS_THAN_0");
        response.put("22", "USER_DETAILS_FLAG");
        response.put("23", "AVATAR_NOT_FOUND");
        response.put("24", "TABLE_NOT_FOUND");
        response.put("25", "CLUB_NOT_FOUND");
        response.put("26", "TRANSACTION_NOT_FOUND");
        response.put("27", "USER_NOT_FOUND");
        response.put("28", "SMALL_BLIND_EXCEEDED");
        response.put("29", "BB_MUST_TWICE_SB");
        response.put("30", "BUY_IN_MIN_LESS_BB");
        response.put("31", "BUY_IN_MAZ_GREATER_BB");
        response.put("32", "SUBSCRIPTION_NOT_FOUND");
        response.put("33", "GAME_TYPE_NOT_FOUND");
        response.put("34", "TABLE_LIMIT_EXCEEDED");
        response.put("35", "CLUB_NOT_SUBSCRIBED");
        response.put("36", "GAME_INFORMATION_NOT_FOUND");
        response.put("37", "TABLE_NOT_ACTIVE");
        response.put("38", "USER_NOT_PLAYING");
        response.put("39", "ALREADY_SUBSCRIBED_TO_SILVER");
        response.put("40", "USER_NOT_SUBSCRIBED");
        response.put("41", "INVALID_DAY");
        response.put("42", "CLUB_AVATAR_NOT_FOUND");
        response.put("43", "CLUB_INFO_DATA_NOT_FOUND");
        response.put("44", "ALREADY_JOINED_THE_SAME_CLUB");
        response.put("45", "PLAYER_DONT_HAVE_ENOUGH_CHIPS");
        response.put("46", "NOT_REQUESTED_CHIPS");
        response.put("47", "PLAYER_LIMIT_EXCEEDED");
        response.put("48", "CANNOT_BE_ZERO");
        response.put("49", "INVALID_DATE");
        response.put("50", "FILE_SIZE_TO_LARGE");
        response.put("51", "INVALID_FILE_TYPE");
        response.put("52", "SAME_PASSWORD");
        response.put("53", "OLD_PASSWORD_DOES_NOT_MATCH");
        response.put("54", "INVALID_PASSWORD");
        response.put("55", "INVALID_START_DATE_GREATER_END_DATE");
        response.put("56", "CLUB_DISBAND");
        response.put("57", "CLUB_INACTIVE");
        response.put("58", "NON_EMPTY_NUMERIC_ARRAY_EXPECTED");
        response.put("59", "INVALID_STATUS");
        response.put("60", "DEFAULT_LOGO_FALSE");
        response.put("61", "DEFAULT_LOGO_TRUE");
        response.put("62", "LEDGER_ENTRY_NOT_FOUND_FOR_CLUB");
        response.put("63", "INVALID_BOOLEAN_DATA");
        response.put("64", "CLUB_STATUS_MISMATCH");
        response.put("65", "HOST_NOT_OF_CLUB");
        response.put("66", "BAD_ARRAY_FORMAT");
        response.put("67", "INVALID_EMAIL");
        response.put("68", "ALREADY_LOGGED_WIH_FB");
        response.put("69", "CHIPS_SEND_LIMIT_EXCEED");
        response.put("70", "INVALID_VALID_TABLE_TYPE");
        response.put("71", "MIN_STACK_NOT_IN_RANGE");
        response.put("72", "NAME_ALREADY_TAKEN");
        response.put("73", "SERVICE_UNAVAILABLE");
        response.put("74", "CANNOT_UPDATE_HOST_ROLE");
        response.put("75", "INVALID_ROLE");
        response.put("76", "FORBIDDEN");
        response.put("77", "MAX_ROLES_EXIST");
        response.put("78", "CANNOT_UPDATE_SELF_ROLE");
        response.put("79", "INSUFFICIENT_CLUB_CHIPS");
        response.put("80", "TRANSACTION_FAILED");
        response.put("81", "INSUFFICIENT_GEMS");
        response.put("82", "CLUB_LIMIT_EXCEEDED");
        response.put("83", "PRODUCT_NOT_FOUND");
        response.put("84", "ITEM_ALREADY_OWNED");
        response.put("85", "PURCHASE_FAILED");
        response.put("86", "NOT_IN_RANGE");
        response.put("87", "INVALID_CLUB_UNIQUE_ID");
        response.put("88", "ROYALTY_CARD_CANNOT_BE_DOWNGRADED");
        response.put("89", "ROYALTY_CARD_ALREADY_PURCHASED");
        response.put("90", "ROYALTY_CARD_CANNOT_BE_UPGRADED");
        response.put("91", "ITEM_NOT_FOUND_IN_ROYALTY_CARD");

        return response;
    }


}