package com.github.sebastianmann.betriebsstellenrestapi.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.lang.Nullable;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@ToString
public class Betriebsstelle {

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String plc;

    @NonNull
    String rl100Code;

    @NonNull
    String rl100NameLong;

    @NonNull
    String rl100NameShort;

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String typeShort;

    @NonNull
    String typeLong;

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String operationCondition;

    @NonNull
    Integer dateFrom;

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    Integer dateTo;

    @NonNull
    Integer branch;

    @Nullable
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String region;

    @NonNull
    Integer lastChange;

}
