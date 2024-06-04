package com.example.sabeelconnect.uicomponents

import com.example.sabeelconnect.R
import java.util.ArrayList

data class CountryCode(
    var countryCode: String,
    val countryPhoneCode: String = "",
    val countryName: String = "",
    val flagResID: Int = 0
)

fun getFlags(countryName: String): Int {
    return when (countryName) {
        "ad" -> R.drawable.flag_andorra
        "ae" -> R.drawable.flag_uae
        "af" -> R.drawable.flag_afghanistan
        "ag" -> R.drawable.flag_antigua_and_barbuda
        "ai" -> R.drawable.flag_anguilla
        "al" -> R.drawable.flag_albania
        "am" -> R.drawable.flag_armenia
        "ao" -> R.drawable.flag_angola
        "aq" -> R.drawable.flag_antarctica
        "ar" -> R.drawable.flag_argentina
        "as" -> R.drawable.flag_american_samoa
        "at" -> R.drawable.flag_austria
        "au" -> R.drawable.flag_australia
        "aw" -> R.drawable.flag_aruba
        "ax" -> R.drawable.flag_aland
        "az" -> R.drawable.flag_azerbaijan
        "ba" -> R.drawable.flag_bosnia
        "bb" -> R.drawable.flag_barbados
        "bd" -> R.drawable.flag_bangladesh
        "be" -> R.drawable.flag_belgium
        "bf" -> R.drawable.flag_burkina_faso
        "bg" -> R.drawable.flag_bulgaria
        "bh" -> R.drawable.flag_bahrain
        "bi" -> R.drawable.flag_burundi
        "bj" -> R.drawable.flag_benin
        "bl" -> R.drawable.flag_saint_barthelemy // custom
        "bm" -> R.drawable.flag_bermuda
        "bn" -> R.drawable.flag_brunei
        "bo" -> R.drawable.flag_bolivia
        "br" -> R.drawable.flag_brazil
        "bs" -> R.drawable.flag_bahamas
        "bt" -> R.drawable.flag_bhutan
        "bw" -> R.drawable.flag_botswana
        "by" -> R.drawable.flag_belarus
        "bz" -> R.drawable.flag_belize
        "ca" -> R.drawable.flag_canada
        "cc" -> R.drawable.flag_cocos // custom
        "cd" -> R.drawable.flag_democratic_republic_of_the_congo
        "cf" -> R.drawable.flag_central_african_republic
        "cg" -> R.drawable.flag_republic_of_the_congo
        "ch" -> R.drawable.flag_switzerland
        "ci" -> R.drawable.flag_cote_divoire
        "ck" -> R.drawable.flag_cook_islands
        "cl" -> R.drawable.flag_chile
        "cm" -> R.drawable.flag_cameroon
        "cn" -> R.drawable.flag_china
        "co" -> R.drawable.flag_colombia
        "cr" -> R.drawable.flag_costa_rica
        "cu" -> R.drawable.flag_cuba
        "cv" -> R.drawable.flag_cape_verde
        "cw" -> R.drawable.flag_curacao
        "cx" -> R.drawable.flag_christmas_island
        "cy" -> R.drawable.flag_cyprus
        "cz" -> R.drawable.flag_czech_republic
        "de" -> R.drawable.flag_germany
        "dj" -> R.drawable.flag_djibouti
        "dk" -> R.drawable.flag_denmark
        "dm" -> R.drawable.flag_dominica
        "do" -> R.drawable.flag_dominican_republic
        "dz" -> R.drawable.flag_algeria
        "ec" -> R.drawable.flag_ecuador
        "ee" -> R.drawable.flag_estonia
        "eg" -> R.drawable.flag_egypt
        "er" -> R.drawable.flag_eritrea
        "es" -> R.drawable.flag_spain
        "et" -> R.drawable.flag_ethiopia
        "fi" -> R.drawable.flag_finland
        "fj" -> R.drawable.flag_fiji
        "fk" -> R.drawable.flag_falkland_islands
        "fm" -> R.drawable.flag_micronesia
        "fo" -> R.drawable.flag_faroe_islands
        "fr" -> R.drawable.flag_france
        "ga" -> R.drawable.flag_gabon
        "gb" -> R.drawable.flag_united_kingdom
        "gd" -> R.drawable.flag_grenada
        "ge" -> R.drawable.flag_georgia
        "gf" -> R.drawable.flag_guyane
        "gg" -> R.drawable.flag_guernsey
        "gh" -> R.drawable.flag_ghana
        "gi" -> R.drawable.flag_gibraltar
        "gl" -> R.drawable.flag_greenland
        "gm" -> R.drawable.flag_gambia
        "gn" -> R.drawable.flag_guinea
        "gp" -> R.drawable.flag_guadeloupe
        "gq" -> R.drawable.flag_equatorial_guinea
        "gr" -> R.drawable.flag_greece
        "gt" -> R.drawable.flag_guatemala
        "gu" -> R.drawable.flag_guam
        "gw" -> R.drawable.flag_guinea_bissau
        "gy" -> R.drawable.flag_guyana
        "hk" -> R.drawable.flag_hong_kong
        "hn" -> R.drawable.flag_honduras
        "hr" -> R.drawable.flag_croatia
        "ht" -> R.drawable.flag_haiti
        "hu" -> R.drawable.flag_hungary
        "id" -> R.drawable.flag_indonesia
        "ie" -> R.drawable.flag_ireland
        "im" -> R.drawable.flag_isleof_man // custom
        "is" -> R.drawable.flag_iceland
        "in" -> R.drawable.flag_india
        "io" -> R.drawable.flag_british_indian_ocean_territory
        "iq" -> R.drawable.flag_iraq_new
        "ir" -> R.drawable.flag_iran
        "it" -> R.drawable.flag_italy
        "je" -> R.drawable.flag_jersey
        "jm" -> R.drawable.flag_jamaica
        "jo" -> R.drawable.flag_jordan
        "jp" -> R.drawable.flag_japan
        "ke" -> R.drawable.flag_kenya
        "kg" -> R.drawable.flag_kyrgyzstan
        "kh" -> R.drawable.flag_cambodia
        "ki" -> R.drawable.flag_kiribati
        "km" -> R.drawable.flag_comoros
        "kn" -> R.drawable.flag_saint_kitts_and_nevis
        "kp" -> R.drawable.flag_north_korea
        "kr" -> R.drawable.flag_south_korea
        "kw" -> R.drawable.flag_kuwait
        "ky" -> R.drawable.flag_cayman_islands
        "kz" -> R.drawable.flag_kazakhstan
        "la" -> R.drawable.flag_laos
        "lb" -> R.drawable.flag_lebanon
        "lc" -> R.drawable.flag_saint_lucia
        "li" -> R.drawable.flag_liechtenstein
        "lk" -> R.drawable.flag_sri_lanka
        "lr" -> R.drawable.flag_liberia
        "ls" -> R.drawable.flag_lesotho
        "lt" -> R.drawable.flag_lithuania
        "lu" -> R.drawable.flag_luxembourg
        "lv" -> R.drawable.flag_latvia
        "ly" -> R.drawable.flag_libya
        "ma" -> R.drawable.flag_morocco
        "mc" -> R.drawable.flag_monaco
        "md" -> R.drawable.flag_moldova
        "me" -> R.drawable.flag_of_montenegro // custom
        "mf" -> R.drawable.flag_saint_martin
        "mg" -> R.drawable.flag_madagascar
        "mh" -> R.drawable.flag_marshall_islands
        "mk" -> R.drawable.flag_macedonia
        "ml" -> R.drawable.flag_mali
        "mm" -> R.drawable.flag_myanmar
        "mn" -> R.drawable.flag_mongolia
        "mo" -> R.drawable.flag_macao
        "mp" -> R.drawable.flag_northern_mariana_islands
        "mq" -> R.drawable.flag_martinique
        "mr" -> R.drawable.flag_mauritania
        "ms" -> R.drawable.flag_montserrat
        "mt" -> R.drawable.flag_malta
        "mu" -> R.drawable.flag_mauritius
        "mv" -> R.drawable.flag_maldives
        "mw" -> R.drawable.flag_malawi
        "mx" -> R.drawable.flag_mexico
        "my" -> R.drawable.flag_malaysia
        "mz" -> R.drawable.flag_mozambique
        "na" -> R.drawable.flag_namibia
        "nc" -> R.drawable.flag_new_caledonia // custom
        "ne" -> R.drawable.flag_niger
        "nf" -> R.drawable.flag_norfolk_island
        "ng" -> R.drawable.flag_nigeria
        "ni" -> R.drawable.flag_nicaragua
        "nl" -> R.drawable.flag_netherlands
        "no" -> R.drawable.flag_norway
        "np" -> R.drawable.flag_nepal
        "nr" -> R.drawable.flag_nauru
        "nu" -> R.drawable.flag_niue
        "nz" -> R.drawable.flag_new_zealand
        "om" -> R.drawable.flag_oman
        "pa" -> R.drawable.flag_panama
        "pe" -> R.drawable.flag_peru
        "pf" -> R.drawable.flag_french_polynesia
        "pg" -> R.drawable.flag_papua_new_guinea
        "ph" -> R.drawable.flag_philippines
        "pk" -> R.drawable.flag_pakistan
        "pl" -> R.drawable.flag_poland
        "pm" -> R.drawable.flag_saint_pierre
        "pn" -> R.drawable.flag_pitcairn_islands
        "pr" -> R.drawable.flag_puerto_rico
        "ps" -> R.drawable.flag_palestine
        "pt" -> R.drawable.flag_portugal
        "pw" -> R.drawable.flag_palau
        "py" -> R.drawable.flag_paraguay
        "qa" -> R.drawable.flag_qatar
        "re" -> R.drawable.flag_martinique // no exact flag found
        "ro" -> R.drawable.flag_romania
        "rs" -> R.drawable.flag_serbia // custom
        "ru" -> R.drawable.flag_russian_federation
        "rw" -> R.drawable.flag_rwanda
        "sa" -> R.drawable.flag_saudi_arabia
        "sb" -> R.drawable.flag_soloman_islands
        "sc" -> R.drawable.flag_seychelles
        "sd" -> R.drawable.flag_sudan
        "se" -> R.drawable.flag_sweden
        "sg" -> R.drawable.flag_singapore
        "sh" -> R.drawable.flag_saint_helena // custom
        "si" -> R.drawable.flag_slovenia
        "sk" -> R.drawable.flag_slovakia
        "sl" -> R.drawable.flag_sierra_leone
        "sm" -> R.drawable.flag_san_marino
        "sn" -> R.drawable.flag_senegal
        "so" -> R.drawable.flag_somalia
        "sr" -> R.drawable.flag_suriname
        "ss" -> R.drawable.flag_south_sudan
        "st" -> R.drawable.flag_sao_tome_and_principe
        "sv" -> R.drawable.flag_el_salvador
        "sx" -> R.drawable.flag_sint_maarten
        "sy" -> R.drawable.flag_syria
        "sz" -> R.drawable.flag_swaziland
        "tc" -> R.drawable.flag_turks_and_caicos_islands
        "td" -> R.drawable.flag_chad
        "tg" -> R.drawable.flag_togo
        "th" -> R.drawable.flag_thailand
        "tj" -> R.drawable.flag_tajikistan
        "tk" -> R.drawable.flag_tokelau // custom
        "tl" -> R.drawable.flag_timor_leste
        "tm" -> R.drawable.flag_turkmenistan
        "tn" -> R.drawable.flag_tunisia
        "to" -> R.drawable.flag_tonga
        "tr" -> R.drawable.flag_turkey
        "tt" -> R.drawable.flag_trinidad_and_tobago
        "tv" -> R.drawable.flag_tuvalu
        "tw" -> R.drawable.flag_taiwan
        "tz" -> R.drawable.flag_tanzania
        "ua" -> R.drawable.flag_ukraine
        "ug" -> R.drawable.flag_uganda
        "us" -> R.drawable.flag_united_states_of_america
        "uy" -> R.drawable.flag_uruguay
        "uz" -> R.drawable.flag_uzbekistan
        "va" -> R.drawable.flag_vatican_city
        "vc" -> R.drawable.flag_saint_vicent_and_the_grenadines
        "ve" -> R.drawable.flag_venezuela
        "vg" -> R.drawable.flag_british_virgin_islands
        "vi" -> R.drawable.flag_us_virgin_islands
        "vn" -> R.drawable.flag_vietnam
        "vu" -> R.drawable.flag_vanuatu
        "wf" -> R.drawable.flag_wallis_and_futuna
        "ws" -> R.drawable.flag_samoa
        "xk" -> R.drawable.flag_kosovo
        "ye" -> R.drawable.flag_yemen
        "yt" -> R.drawable.flag_martinique // no exact flag found
        "za" -> R.drawable.flag_south_africa
        "zm" -> R.drawable.flag_zambia
        "zw" -> R.drawable.flag_zimbabwe
        else -> R.drawable.flag_transparent
    }
}

fun getListOfCountries(): List<CountryCode> {
    val countries: MutableList<CountryCode> = ArrayList()
    countries.add(CountryCode("ad", "+376", "Andorra"))
    countries.add(CountryCode("ae", "+971", "United Arab Emirates (UAE)"))
    countries.add(CountryCode("af", "+93", "Afghanistan"))
    countries.add(CountryCode("ag", "+1", "Antigua and Barbuda"))
    countries.add(CountryCode("ai", "+1", "Anguilla"))
    countries.add(CountryCode("al", "+355", "Albania"))
    countries.add(CountryCode("am", "+374", "Armenia"))
    countries.add(CountryCode("ao", "+244", "Angola"))
    countries.add(CountryCode("aq", "+672", "Antarctica"))
    countries.add(CountryCode("ar", "+54", "Argentina"))
    countries.add(CountryCode("as", "+1", "American Samoa"))
    countries.add(CountryCode("at", "+43", "Austria"))
    countries.add(CountryCode("au", "+61", "Australia"))
    countries.add(CountryCode("aw", "+297", "Aruba"))
    countries.add(CountryCode("ax", "+358", "Åland Islands"))
    countries.add(CountryCode("az", "+994", "Azerbaijan"))
    countries.add(CountryCode("ba", "+387", "Bosnia And Herzegovina"))
    countries.add(CountryCode("bb", "+1", "Barbados"))
    countries.add(CountryCode("bd", "+880", "Bangladesh"))
    countries.add(CountryCode("be", "+32", "Belgium"))
    countries.add(CountryCode("bf", "+226", "Burkina Faso"))
    countries.add(CountryCode("bg", "+359", "Bulgaria"))
    countries.add(CountryCode("bh", "+973", "Bahrain"))
    countries.add(CountryCode("bi", "+257", "Burundi"))
    countries.add(CountryCode("bj", "+229", "Benin"))
    countries.add(CountryCode("bl", "+590", "Saint Barthélemy"))
    countries.add(CountryCode("bm", "+1", "Bermuda"))
    countries.add(CountryCode("bn", "+673", "Brunei Darussalam"))
    countries.add(CountryCode("bo", "+591", "Bolivia, Plurinational State Of"))
    countries.add(CountryCode("br", "+55", "Brazil"))
    countries.add(CountryCode("bs", "+1", "Bahamas"))
    countries.add(CountryCode("bt", "+975", "Bhutan"))
    countries.add(CountryCode("bw", "+267", "Botswana"))
    countries.add(CountryCode("by", "+375", "Belarus"))
    countries.add(CountryCode("bz", "+501", "Belize"))
    countries.add(CountryCode("ca", "+1", "Canada"))
    countries.add(CountryCode("cc", "+61", "Cocos (keeling) Islands"))
    countries.add(CountryCode("cd", "+243", "Congo, The Democratic Republic Of The"))
    countries.add(CountryCode("cf", "+236", "Central African Republic"))
    countries.add(CountryCode("cg", "+242", "Congo"))
    countries.add(CountryCode("ch", "+41", "Switzerland"))
    countries.add(CountryCode("ci", "+225", "Côte D'ivoire"))
    countries.add(CountryCode("ck", "+682", "Cook Islands"))
    countries.add(CountryCode("cl", "+56", "Chile"))
    countries.add(CountryCode("cm", "+237", "Cameroon"))
    countries.add(CountryCode("cn", "+86", "China"))
    countries.add(CountryCode("co", "+57", "Colombia"))
    countries.add(CountryCode("cr", "+506", "Costa Rica"))
    countries.add(CountryCode("cu", "+53", "Cuba"))
    countries.add(CountryCode("cv", "+238", "Cape Verde"))
    countries.add(CountryCode("cw", "+599", "Curaçao"))
    countries.add(CountryCode("cx", "+61", "Christmas Island"))
    countries.add(CountryCode("cy", "+357", "Cyprus"))
    countries.add(CountryCode("cz", "+420", "Czech Republic"))
    countries.add(CountryCode("de", "+49", "Germany"))
    countries.add(CountryCode("dj", "+253", "Djibouti"))
    countries.add(CountryCode("dk", "+45", "Denmark"))
    countries.add(CountryCode("dm", "+1", "Dominica"))
    countries.add(CountryCode("do", "+1", "Dominican Republic"))
    countries.add(CountryCode("dz", "+213", "Algeria"))
    countries.add(CountryCode("ec", "+593", "Ecuador"))
    countries.add(CountryCode("ee", "+372", "Estonia"))
    countries.add(CountryCode("eg", "+20", "Egypt"))
    countries.add(CountryCode("er", "+291", "Eritrea"))
    countries.add(CountryCode("es", "+34", "Spain"))
    countries.add(CountryCode("et", "+251", "Ethiopia"))
    countries.add(CountryCode("fi", "+358", "Finland"))
    countries.add(CountryCode("fj", "+679", "Fiji"))
    countries.add(CountryCode("fk", "+500", "Falkland Islands (malvinas)"))
    countries.add(CountryCode("fm", "+691", "Micronesia, Federated States Of"))
    countries.add(CountryCode("fo", "+298", "Faroe Islands"))
    countries.add(CountryCode("fr", "+33", "France"))
    countries.add(CountryCode("ga", "+241", "Gabon"))
    countries.add(CountryCode("gb", "+44", "United Kingdom"))
    countries.add(CountryCode("gd", "+1", "Grenada"))
    countries.add(CountryCode("ge", "+995", "Georgia"))
    countries.add(CountryCode("gf", "+594", "French Guyana"))
    countries.add(CountryCode("gh", "+233", "Ghana"))
    countries.add(CountryCode("gi", "+350", "Gibraltar"))
    countries.add(CountryCode("gl", "+299", "Greenland"))
    countries.add(CountryCode("gm", "+220", "Gambia"))
    countries.add(CountryCode("gn", "+224", "Guinea"))
    countries.add(CountryCode("gp", "+450", "Guadeloupe"))
    countries.add(CountryCode("gq", "+240", "Equatorial Guinea"))
    countries.add(CountryCode("gr", "+30", "Greece"))
    countries.add(CountryCode("gt", "+502", "Guatemala"))
    countries.add(CountryCode("gu", "+1", "Guam"))
    countries.add(CountryCode("gw", "+245", "Guinea-bissau"))
    countries.add(CountryCode("gy", "+592", "Guyana"))
    countries.add(CountryCode("hk", "+852", "Hong Kong"))
    countries.add(CountryCode("hn", "+504", "Honduras"))
    countries.add(CountryCode("hr", "+385", "Croatia"))
    countries.add(CountryCode("ht", "+509", "Haiti"))
    countries.add(CountryCode("hu", "+36", "Hungary"))
    countries.add(CountryCode("id", "+62", "Indonesia"))
    countries.add(CountryCode("ie", "+353", "Ireland"))
    countries.add(CountryCode("im", "+44", "Isle Of Man"))
    countries.add(CountryCode("is", "+354", "Iceland"))
    countries.add(CountryCode("in", "+91", "India"))
    countries.add(CountryCode("io", "+246", "British Indian Ocean Territory"))
    countries.add(CountryCode("iq", "+964", "Iraq"))
    countries.add(CountryCode("ir", "+98", "Iran, Islamic Republic Of"))
    countries.add(CountryCode("it", "+39", "Italy"))
    countries.add(CountryCode("je", "+44", "Jersey "))
    countries.add(CountryCode("jm", "+1", "Jamaica"))
    countries.add(CountryCode("jo", "+962", "Jordan"))
    countries.add(CountryCode("jp", "+81", "Japan"))
    countries.add(CountryCode("ke", "+254", "Kenya"))
    countries.add(CountryCode("kg", "+996", "Kyrgyzstan"))
    countries.add(CountryCode("kh", "+855", "Cambodia"))
    countries.add(CountryCode("ki", "+686", "Kiribati"))
    countries.add(CountryCode("km", "+269", "Comoros"))
    countries.add(CountryCode("kn", "+1", "Saint Kitts and Nevis"))
    countries.add(CountryCode("kp", "+850", "North Korea"))
    countries.add(CountryCode("kr", "+82", "South Korea"))
    countries.add(CountryCode("kw", "+965", "Kuwait"))
    countries.add(CountryCode("ky", "+1", "Cayman Islands"))
    countries.add(CountryCode("kz", "+7", "Kazakhstan"))
    countries.add(CountryCode("la", "+856", "Lao People's Democratic Republic"))
    countries.add(CountryCode("lb", "+961", "Lebanon"))
    countries.add(CountryCode("lc", "+1", "Saint Lucia"))
    countries.add(CountryCode("li", "+423", "Liechtenstein"))
    countries.add(CountryCode("lk", "+94", "Sri Lanka"))
    countries.add(CountryCode("lr", "+231", "Liberia"))
    countries.add(CountryCode("ls", "+266", "Lesotho"))
    countries.add(CountryCode("lt", "+370", "Lithuania"))
    countries.add(CountryCode("lu", "+352", "Luxembourg"))
    countries.add(CountryCode("lv", "+371", "Latvia"))
    countries.add(CountryCode("ly", "+218", "Libya"))
    countries.add(CountryCode("ma", "+212", "Morocco"))
    countries.add(CountryCode("mc", "+377", "Monaco"))
    countries.add(CountryCode("md", "+373", "Moldova, Republic Of"))
    countries.add(CountryCode("me", "+382", "Montenegro"))
    countries.add(CountryCode("mf", "+590", "Saint Martin"))
    countries.add(CountryCode("mg", "+261", "Madagascar"))
    countries.add(CountryCode("mh", "+692", "Marshall Islands"))
    countries.add(CountryCode("mk", "+389", "Macedonia (FYROM)"))
    countries.add(CountryCode("ml", "+223", "Mali"))
    countries.add(CountryCode("mm", "+95", "Myanmar"))
    countries.add(CountryCode("mn", "+976", "Mongolia"))
    countries.add(CountryCode("mo", "+853", "Macau"))
    countries.add(CountryCode("mp", "+1", "Northern Mariana Islands"))
    countries.add(CountryCode("mq", "+596", "Martinique"))
    countries.add(CountryCode("mr", "+222", "Mauritania"))
    countries.add(CountryCode("ms", "+1", "Montserrat"))
    countries.add(CountryCode("mt", "+356", "Malta"))
    countries.add(CountryCode("mu", "+230", "Mauritius"))
    countries.add(CountryCode("mv", "+960", "Maldives"))
    countries.add(CountryCode("mw", "+265", "Malawi"))
    countries.add(CountryCode("mx", "+52", "Mexico"))
    countries.add(CountryCode("my", "+60", "Malaysia"))
    countries.add(CountryCode("mz", "+258", "Mozambique"))
    countries.add(CountryCode("na", "+264", "Namibia"))
    countries.add(CountryCode("nc", "+687", "New Caledonia"))
    countries.add(CountryCode("ne", "+227", "Niger"))
    countries.add(CountryCode("nf", "+672", "Norfolk Islands"))
    countries.add(CountryCode("ng", "+234", "Nigeria"))
    countries.add(CountryCode("ni", "+505", "Nicaragua"))
    countries.add(CountryCode("nl", "+31", "Netherlands"))
    countries.add(CountryCode("no", "+47", "Norway"))
    countries.add(CountryCode("np", "+977", "Nepal"))
    countries.add(CountryCode("nr", "+674", "Nauru"))
    countries.add(CountryCode("nu", "+683", "Niue"))
    countries.add(CountryCode("nz", "+64", "New Zealand"))
    countries.add(CountryCode("om", "+968", "Oman"))
    countries.add(CountryCode("pa", "+507", "Panama"))
    countries.add(CountryCode("pe", "+51", "Peru"))
    countries.add(CountryCode("pf", "+689", "French Polynesia"))
    countries.add(CountryCode("pg", "+675", "Papua New Guinea"))
    countries.add(CountryCode("ph", "+63", "Philippines"))
    countries.add(CountryCode("pk", "+92", "Pakistan"))
    countries.add(CountryCode("pl", "+48", "Poland"))
    countries.add(CountryCode("pm", "+508", "Saint Pierre And Miquelon"))
    countries.add(CountryCode("pn", "+870", "Pitcairn Islands"))
    countries.add(CountryCode("pr", "+1", "Puerto Rico"))
    countries.add(CountryCode("ps", "+970", "Palestine"))
    countries.add(CountryCode("pt", "+351", "Portugal"))
    countries.add(CountryCode("pw", "+680", "Palau"))
    countries.add(CountryCode("py", "+595", "Paraguay"))
    countries.add(CountryCode("qa", "+974", "Qatar"))
    countries.add(CountryCode("re", "+262", "Réunion"))
    countries.add(CountryCode("ro", "+40", "Romania"))
    countries.add(CountryCode("rs", "+381", "Serbia"))
    countries.add(CountryCode("ru", "+7", "Russian Federation"))
    countries.add(CountryCode("rw", "+250", "Rwanda"))
    countries.add(CountryCode("sa", "+966", "Saudi Arabia"))
    countries.add(CountryCode("sb", "+677", "Solomon Islands"))
    countries.add(CountryCode("sc", "+248", "Seychelles"))
    countries.add(CountryCode("sd", "+249", "Sudan"))
    countries.add(CountryCode("se", "+46", "Sweden"))
    countries.add(CountryCode("sg", "+65", "Singapore"))
    countries.add(CountryCode("sh", "+290", "Saint Helena, Ascension And Tristan Da Cunha"))
    countries.add(CountryCode("si", "+386", "Slovenia"))
    countries.add(CountryCode("sk", "+421", "Slovakia"))
    countries.add(CountryCode("sl", "+232", "Sierra Leone"))
    countries.add(CountryCode("sm", "+378", "San Marino"))
    countries.add(CountryCode("sn", "+221", "Senegal"))
    countries.add(CountryCode("so", "+252", "Somalia"))
    countries.add(CountryCode("sr", "+597", "Suriname"))
    countries.add(CountryCode("ss", "+211", "South Sudan"))
    countries.add(CountryCode("st", "+239", "Sao Tome And Principe"))
    countries.add(CountryCode("sv", "+503", "El Salvador"))
    countries.add(CountryCode("sx", "+1", "Sint Maarten"))
    countries.add(CountryCode("sy", "+963", "Syrian Arab Republic"))
    countries.add(CountryCode("sz", "+268", "Swaziland"))
    countries.add(CountryCode("tc", "+1", "Turks and Caicos Islands"))
    countries.add(CountryCode("td", "+235", "Chad"))
    countries.add(CountryCode("tg", "+228", "Togo"))
    countries.add(CountryCode("th", "+66", "Thailand"))
    countries.add(CountryCode("tj", "+992", "Tajikistan"))
    countries.add(CountryCode("tk", "+690", "Tokelau"))
    countries.add(CountryCode("tl", "+670", "Timor-leste"))
    countries.add(CountryCode("tm", "+993", "Turkmenistan"))
    countries.add(CountryCode("tn", "+216", "Tunisia"))
    countries.add(CountryCode("to", "+676", "Tonga"))
    countries.add(CountryCode("tr", "+90", "Turkey"))
    countries.add(CountryCode("tt", "+1", "Trinidad &amp; Tobago"))
    countries.add(CountryCode("tv", "+688", "Tuvalu"))
    countries.add(CountryCode("tw", "+886", "Taiwan"))
    countries.add(CountryCode("tz", "+255", "Tanzania, United Republic Of"))
    countries.add(CountryCode("ua", "+380", "Ukraine"))
    countries.add(CountryCode("ug", "+256", "Uganda"))
    countries.add(CountryCode("us", "+1", "United States"))
    countries.add(CountryCode("uy", "+598", "Uruguay"))
    countries.add(CountryCode("uz", "+998", "Uzbekistan"))
    countries.add(CountryCode("va", "+379", "Holy See (vatican City State)"))
    countries.add(CountryCode("vc", "+1", "Saint Vincent &amp; The Grenadines"))
    countries.add(CountryCode("ve", "+58", "Venezuela, Bolivarian Republic Of"))
    countries.add(CountryCode("vg", "+1", "British Virgin Islands"))
    countries.add(CountryCode("vi", "+1", "US Virgin Islands"))
    countries.add(CountryCode("vn", "+84", "Vietnam"))
    countries.add(CountryCode("vu", "+678", "Vanuatu"))
    countries.add(CountryCode("wf", "+681", "Wallis And Futuna"))
    countries.add(CountryCode("ws", "4685", "Samoa"))
    countries.add(CountryCode("xk", "+383", "Kosovo"))
    countries.add(CountryCode("ye", "+967", "Yemen"))
    countries.add(CountryCode("yt", "+262", "Mayotte"))
    countries.add(CountryCode("za", "+27", "South Africa"))
    countries.add(CountryCode("zm", "+260", "Zambia"))
    countries.add(CountryCode("zw", "+263", "Zimbabwe"))
    return countries
}

val countryData = mapOf(
    "Afghanistan" to Pair("+93", R.drawable.flag_afghanistan),
    "Albania" to Pair("+355", R.drawable.flag_albania),
    "Algeria" to Pair("+213", R.drawable.flag_algeria),
    "Andorra" to Pair("+376", R.drawable.flag_andorra),
    "Angola" to Pair("+244", R.drawable.flag_angola),
    "Antigua and Barbuda" to Pair("+1-268", R.drawable.flag_antigua_and_barbuda),
    "Argentina" to Pair("+54", R.drawable.flag_argentina),
    "Armenia" to Pair("+374", R.drawable.flag_armenia),
    "Australia" to Pair("+61", R.drawable.flag_australia),
    "Austria" to Pair("+43", R.drawable.flag_austria),
    "Azerbaijan" to Pair("+994", R.drawable.flag_azerbaijan),
    "Bahamas" to Pair("+1-242", R.drawable.flag_bahamas),
    "Bahrain" to Pair("+973", R.drawable.flag_bahrain),
    "Bangladesh" to Pair("+880", R.drawable.flag_bangladesh),
    "Barbados" to Pair("+1-246", R.drawable.flag_barbados),
    "Belarus" to Pair("+375", R.drawable.flag_belarus),
    "Belgium" to Pair("+32", R.drawable.flag_belgium),
    "Belize" to Pair("+501", R.drawable.flag_belize),
    "Benin" to Pair("+229", R.drawable.flag_benin),
    "Bhutan" to Pair("+975", R.drawable.flag_bhutan),
    "Bolivia" to Pair("+591", R.drawable.flag_bolivia),
    //"Bosnia and Herzegovina" to Pair("+387", R.drawable.flag_bosnia_and_herzegovina),
    "Botswana" to Pair("+267", R.drawable.flag_botswana),
    "Brazil" to Pair("+55", R.drawable.flag_brazil),
    "Brunei Darussalam" to Pair("+673", R.drawable.flag_brunei),
    "Bulgaria" to Pair("+359", R.drawable.flag_bulgaria),
    "Burkina Faso" to Pair("+226", R.drawable.flag_burkina_faso),
    "Burundi" to Pair("+257", R.drawable.flag_burundi),
    "Cabo Verde" to Pair("+238", R.drawable.flag_cape_verde),
    "Cambodia" to Pair("+855", R.drawable.flag_cambodia),
    "Cameroon" to Pair("+237", R.drawable.flag_cameroon),
    "Canada" to Pair("+1", R.drawable.flag_canada),
    "Central African Republic" to Pair("+236", R.drawable.flag_central_african_republic),
    "Chad" to Pair("+235", R.drawable.flag_chad),
    "Chile" to Pair("+56", R.drawable.flag_chile),
    "China" to Pair("+86", R.drawable.flag_china),
    "Colombia" to Pair("+57", R.drawable.flag_colombia),
    "Comoros" to Pair("+269", R.drawable.flag_comoros),
    //"Congo" to Pair("+242", R.drawable.flag_congo),
    "Costa Rica" to Pair("+506", R.drawable.flag_costa_rica),
    "Croatia" to Pair("+385", R.drawable.flag_croatia),
    "Cuba" to Pair("+53", R.drawable.flag_cuba),
    "Cyprus" to Pair("+357", R.drawable.flag_cyprus),
    "Czech Republic" to Pair("+420", R.drawable.flag_czech_republic),
    "Denmark" to Pair("+45", R.drawable.flag_denmark),
    "Djibouti" to Pair("+253", R.drawable.flag_djibouti),
    "Dominica" to Pair("+1-767", R.drawable.flag_dominica),
    "Dominican Republic" to Pair("+1-809", R.drawable.flag_dominican_republic),
    "Ecuador" to Pair("+593", R.drawable.flag_ecuador),
    "Egypt" to Pair("+20", R.drawable.flag_egypt),
    "El Salvador" to Pair("+503", R.drawable.flag_el_salvador),
    "Equatorial Guinea" to Pair("+240", R.drawable.flag_equatorial_guinea),
    "Eritrea" to Pair("+291", R.drawable.flag_eritrea),
    "Estonia" to Pair("+372", R.drawable.flag_estonia),
    //"Eswatini" to Pair("+268", R.drawable.flag_eswatini),
    "Ethiopia" to Pair("+251", R.drawable.flag_ethiopia),
    "Fiji" to Pair("+679", R.drawable.flag_fiji),
    "Finland" to Pair("+358", R.drawable.flag_finland),
    "France" to Pair("+33", R.drawable.flag_france),
    "Gabon" to Pair("+241", R.drawable.flag_gabon),
    "Gambia" to Pair("+220", R.drawable.flag_gambia),
    "Georgia" to Pair("+995", R.drawable.flag_georgia),
    "Germany" to Pair("+49", R.drawable.flag_germany),
    "Ghana" to Pair("+233", R.drawable.flag_ghana),
    "Greece" to Pair("+30", R.drawable.flag_greece),
    "Grenada" to Pair("+1-473", R.drawable.flag_grenada),
    "Guatemala" to Pair("+502", R.drawable.flag_guatemala),
    "Guinea" to Pair("+224", R.drawable.flag_guinea),
    "Guinea-Bissau" to Pair("+245", R.drawable.flag_guinea_bissau),
    "Guyana" to Pair("+592", R.drawable.flag_guyana),
    "Haiti" to Pair("+509", R.drawable.flag_haiti),
    "Holy See" to Pair("+379", R.drawable.flag_vatican_city),
    "Honduras" to Pair("+504", R.drawable.flag_honduras),
    "Hong Kong" to Pair("+852", R.drawable.flag_hong_kong),
    "Hungary" to Pair("+36", R.drawable.flag_hungary),
    "Iceland" to Pair("+354", R.drawable.flag_iceland),
    "India" to Pair("+91", R.drawable.flag_india),
    "Indonesia" to Pair("+62", R.drawable.flag_indonesia),
    "Iran" to Pair("+98", R.drawable.flag_iran),
    "Iraq" to Pair("+964", R.drawable.flag_iraq),
    "Ireland" to Pair("+353", R.drawable.flag_ireland),
    "Israel" to Pair("+972", R.drawable.flag_israel),
    "Italy" to Pair("+39", R.drawable.flag_italy),
    "Jamaica" to Pair("+1-876", R.drawable.flag_jamaica),
    "Japan" to Pair("+81", R.drawable.flag_japan),
    "Jordan" to Pair("+962", R.drawable.flag_jordan),
    "Kazakhstan" to Pair("+7", R.drawable.flag_kazakhstan),
    "Kenya" to Pair("+254", R.drawable.flag_kenya),
    "Kiribati" to Pair("+686", R.drawable.flag_kiribati),
    "Kuwait" to Pair("+965", R.drawable.flag_kuwait),
    "Kyrgyzstan" to Pair("+996", R.drawable.flag_kyrgyzstan),
    "Laos" to Pair("+856", R.drawable.flag_laos),
    "Latvia" to Pair("+371", R.drawable.flag_latvia),
    "Lebanon" to Pair("+961", R.drawable.flag_lebanon),
    "Lesotho" to Pair("+266", R.drawable.flag_lesotho),
    "Liberia" to Pair("+231", R.drawable.flag_liberia),
    "Libya" to Pair("+218", R.drawable.flag_libya),
    "Liechtenstein" to Pair("+423", R.drawable.flag_liechtenstein),
    "Lithuania" to Pair("+370", R.drawable.flag_lithuania),
    "Luxembourg" to Pair("+352", R.drawable.flag_luxembourg),
    "Macao" to Pair("+853", R.drawable.flag_macao),
    "Madagascar" to Pair("+261", R.drawable.flag_madagascar),
    "Malawi" to Pair("+265", R.drawable.flag_malawi),
    "Malaysia" to Pair("+60", R.drawable.flag_malaysia),
    "Maldives" to Pair("+960", R.drawable.flag_maldives),
    "Mali" to Pair("+223", R.drawable.flag_mali),
    "Malta" to Pair("+356", R.drawable.flag_malta),
    "Marshall Islands" to Pair("+692", R.drawable.flag_marshall_islands),
    "Martinique" to Pair("+596", R.drawable.flag_martinique),
    "Mauritania" to Pair("+222", R.drawable.flag_mauritania),
    "Mauritius" to Pair("+230", R.drawable.flag_mauritius),
    //"Mayotte" to Pair("+262", R.drawable.flag_mayotte),
    "Mexico" to Pair("+52", R.drawable.flag_mexico),
    "Micronesia (Federated States of)" to Pair("+691", R.drawable.flag_micronesia),
    "Moldova" to Pair("+373", R.drawable.flag_moldova),
    "Monaco" to Pair("+377", R.drawable.flag_monaco),
    "Mongolia" to Pair("+976", R.drawable.flag_mongolia),
    //"Montenegro" to Pair("+382", R.drawable.flag_montenegro),
    "Montserrat" to Pair("+1-664", R.drawable.flag_montserrat),
    "Morocco" to Pair("+212", R.drawable.flag_morocco),
    "Mozambique" to Pair("+258", R.drawable.flag_mozambique),
    "Myanmar" to Pair("+95", R.drawable.flag_myanmar),
    "Namibia" to Pair("+264", R.drawable.flag_namibia),
    "Nauru" to Pair("+674", R.drawable.flag_nauru),
    "Nepal" to Pair("+977", R.drawable.flag_nepal),
    "Netherlands" to Pair("+31", R.drawable.flag_netherlands),
    "New Caledonia" to Pair("+687", R.drawable.flag_new_caledonia),
    "New Zealand" to Pair("+64", R.drawable.flag_new_zealand),
    "Nicaragua" to Pair("+505", R.drawable.flag_nicaragua),
    "Niger" to Pair("+227", R.drawable.flag_niger),
    "Nigeria" to Pair("+234", R.drawable.flag_nigeria),
    "Niue" to Pair("+683", R.drawable.flag_niue),
    "Norfolk Island" to Pair("+672", R.drawable.flag_norfolk_island),
    "North Korea" to Pair("+850", R.drawable.flag_north_korea),
    //"North Macedonia" to Pair("+389", R.drawable.flag_north_macedonia),
    "Northern Mariana Islands" to Pair("+1-670", R.drawable.flag_northern_mariana_islands),
    "Norway" to Pair("+47", R.drawable.flag_norway),
    "Oman" to Pair("+968", R.drawable.flag_oman),
    "Pakistan" to Pair("+92", R.drawable.flag_pakistan),
    "Palau" to Pair("+680", R.drawable.flag_palau),
    "Panama" to Pair("+507", R.drawable.flag_panama),
    "Papua New Guinea" to Pair("+675", R.drawable.flag_papua_new_guinea),
    "Paraguay" to Pair("+595", R.drawable.flag_paraguay),
    "Peru" to Pair("+51", R.drawable.flag_peru),
    "Philippines" to Pair("+63", R.drawable.flag_philippines),
    // "Pitcairn" to Pair("+64", R.drawable.flag_pitcairn),
    "Poland" to Pair("+48", R.drawable.flag_poland),
    "Portugal" to Pair("+351", R.drawable.flag_portugal),
    "Puerto Rico" to Pair("+1-787", R.drawable.flag_puerto_rico),
    "Qatar" to Pair("+974", R.drawable.flag_qatar),
    "Romania" to Pair("+40", R.drawable.flag_romania),
    //"Russia" to Pair("+7", R.drawable.flag_russia),
    "Rwanda" to Pair("+250", R.drawable.flag_rwanda),
    //"Réunion" to Pair("+262", R.drawable.flag_reunion),
    "Saint Barthélemy" to Pair("+590", R.drawable.flag_saint_barthelemy),
    "Saint Helena" to Pair("+290", R.drawable.flag_saint_helena),
    "Saint Kitts and Nevis" to Pair("+1-869", R.drawable.flag_saint_kitts_and_nevis),
    "Saint Lucia" to Pair("+1-758", R.drawable.flag_saint_lucia),
    "Saint Martin (French part)" to Pair("+590", R.drawable.flag_saint_martin),
    //"Saint Pierre and Miquelon" to Pair("+508", R.drawable.flag_saint_pierre_and_miquelon),
    //"Saint Vincent and the Grenadines" to Pair("+1-784", R.drawable.flag_saint_vincent_and_the_grenadines),
    "Samoa" to Pair("+685", R.drawable.flag_samoa),
    "San Marino" to Pair("+378", R.drawable.flag_san_marino),
    "Sao Tome and Principe" to Pair("+239", R.drawable.flag_sao_tome_and_principe),
    "Saudi Arabia" to Pair("+966", R.drawable.flag_saudi_arabia),
    "Senegal" to Pair("+221", R.drawable.flag_senegal),
    "Serbia" to Pair("+381", R.drawable.flag_serbia),
    "Seychelles" to Pair("+248", R.drawable.flag_seychelles),
    "Sierra Leone" to Pair("+232", R.drawable.flag_sierra_leone),
    "Singapore" to Pair("+65", R.drawable.flag_singapore),
    "Sint Maarten (Dutch part)" to Pair("+1-721", R.drawable.flag_sint_maarten),
    "Slovakia" to Pair("+421", R.drawable.flag_slovakia),
    "Slovenia" to Pair("+386", R.drawable.flag_slovenia),
    //"Solomon Islands" to Pair("+677", R.drawable.flag_solomon_islands),
    "Somalia" to Pair("+252", R.drawable.flag_somalia),
    "South Africa" to Pair("+27", R.drawable.flag_south_africa),
    //"South Georgia and the South Sandwich Islands" to Pair("+500", R.drawable.flag_south_georgia_and_the_south_sandwich_islands),
    "South Korea" to Pair("+82", R.drawable.flag_south_korea),
    "South Sudan" to Pair("+211", R.drawable.flag_south_sudan),
    "Spain" to Pair("+34", R.drawable.flag_spain),
    "Sri Lanka" to Pair("+94", R.drawable.flag_sri_lanka),
    "Sudan" to Pair("+249", R.drawable.flag_sudan),
    "Suriname" to Pair("+597", R.drawable.flag_suriname),
    "Sweden" to Pair("+46", R.drawable.flag_sweden),
    "Switzerland" to Pair("+41", R.drawable.flag_switzerland),
    "Syria" to Pair("+963", R.drawable.flag_syria),
    "Taiwan" to Pair("+886", R.drawable.flag_taiwan),
    "Tajikistan" to Pair("+992", R.drawable.flag_tajikistan),
    "Tanzania" to Pair("+255", R.drawable.flag_tanzania),
    "Thailand" to Pair("+66", R.drawable.flag_thailand),
    "Timor-Leste" to Pair("+670", R.drawable.flag_timor_leste),
    "Togo" to Pair("+228", R.drawable.flag_togo),
    "Tokelau" to Pair("+690", R.drawable.flag_tokelau),
    "Tonga" to Pair("+676", R.drawable.flag_tonga),
    "Trinidad and Tobago" to Pair("+1-868", R.drawable.flag_trinidad_and_tobago),
    "Tunisia" to Pair("+216", R.drawable.flag_tunisia),
    "Turkey" to Pair("+90", R.drawable.flag_turkey),
    "Turkmenistan" to Pair("+993", R.drawable.flag_turkmenistan),
    "Turks and Caicos Islands" to Pair("+1-649", R.drawable.flag_turks_and_caicos_islands),
    "Tuvalu" to Pair("+688", R.drawable.flag_tuvalu),
    "Uganda" to Pair("+256", R.drawable.flag_uganda),
    "Ukraine" to Pair("+380", R.drawable.flag_ukraine),
    // "United Arab Emirates" to Pair("+971", R.drawable.flag_united_arab_emirates),
    "United Kingdom of Great Britain and Northern Ireland" to Pair("+44", R.drawable.flag_united_kingdom),
    // "United States of America" to Pair("+1", R.drawable.flag_united_states),
    "Uruguay" to Pair("+598", R.drawable.flag_uruguay),
    "Uzbekistan" to Pair("+998", R.drawable.flag_uzbekistan),
    "Vanuatu" to Pair("+678", R.drawable.flag_vanuatu),
    "Venezuela" to Pair("+58", R.drawable.flag_venezuela),
    "Viet Nam" to Pair("+84", R.drawable.flag_vietnam),
    "Wallis and Futuna" to Pair("+681", R.drawable.flag_wallis_and_futuna),
    //"Western Sahara" to Pair("+212", R.drawable.flag_western_sahara),
    "Yemen" to Pair("+967", R.drawable.flag_yemen),
    "Zambia" to Pair("+260", R.drawable.flag_zambia),
    "Zimbabwe" to Pair("+263", R.drawable.flag_zimbabwe)
)