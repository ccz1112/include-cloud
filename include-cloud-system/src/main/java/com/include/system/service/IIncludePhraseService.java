package com.include.system.service;

import com.include.comm.entity.IncludePhrase;
import com.include.comm.entity.R;

/**
 * @projectName include-cloud-common
 * @packageName com.include.system.service
 * @className IIncludePhraseService
 * @author： chenshuo
 * @version： 1.0
 * @since： 2023-08-08 14:00
 */
public interface IIncludePhraseService {
    R save(IncludePhrase includePhrase);

    R joinRoom(String roomCode);

    R getPhrase(String params,String nextParams);
}
