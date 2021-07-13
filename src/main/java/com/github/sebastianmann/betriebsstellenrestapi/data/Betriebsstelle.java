package com.github.sebastianmann.betriebsstellenrestapi.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.Nullable;

/**
 * Data class for a Betriebsstelle.
 */
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Betriebsstelle {

    /**
     * Contains the primary location code for the Betriebsstelle.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String plc;

    /**
     * Contains the RL100Code for the Betriebsstelle.
     * This is used as the id for the web request.
     */
    @NonNull
    String rl100Code;

    /**
     * Contains the RL100Longname for the Betriebsstelle.
     */
    @NonNull
    String rl100NameLong;

    /**
     * Contains the RL100Shortname for the Betriebsstelle.
     */
    @NonNull
    String rl100NameShort;

    /**
     * Contains the short version of the Betriebsstellen-type for the Betriebsstelle.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String typeShort;

    /**
     * Contains the long version of the Betriebsstellen-type for the Betriebsstelle.
     */
    @NonNull
    String typeLong;

    /**
     * Contains the operation condition for the Betriebsstelle.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String operationCondition;

    /**
     * Contains the from-date for the Betriebsstelle.
     * The date is encoded as an integer.
     */
    @NonNull
    Integer dateFrom;

    /**
     * Contains the to-date for the Betriebsstelle, if one exists.
     * The date is encoded as an integer.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Integer dateTo;

    /**
     * Contains the branch for the Betriebsstelle as an integer.
     */
    @NonNull
    Integer branch;

    /**
     * Contains the region for the Betriebsstelle.
     */
    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String region;

    /**
     * Contains the date since the last change to the Betriebsstelle.
     */
    @NonNull
    Integer lastChange;

}
