package com.demo.mms.service;

import com.demo.mms.dao.AdminMapper;
import com.demo.mms.common.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author  teacher
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;
    @Transactional
    @Override
    public void addAdmin(Admin admin) {
        adminMapper.insert(admin);
    }
    }

