package com.example.hibernatedemo.service;

import com.example.hibernatedemo.entity.Boss;
import com.example.hibernatedemo.repository.BossRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BossService {

    private final BossRepository bossRepository;

    public void save(Boss boss){
        bossRepository.save(boss);
    }
}
