package org.example.homework;

import java.sql.SQLException;

public interface DAOModifiersAndObtainersInterface {

    void create(ForHandleAndReturnObj args) throws SQLException;

    ForHandleAndReturnObj findByName(ForHandleAndReturnObj name) throws SQLException;

    ForHandleAndReturnObj findById(ForHandleAndReturnObj id) throws SQLException;

}
