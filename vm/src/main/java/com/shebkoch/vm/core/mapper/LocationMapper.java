package com.shebkoch.vm.core.mapper;

import com.shebkoch.vm.api.model.LocationType;
import com.shebkoch.vm.api.model.entity.Location;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class LocationMapper implements IMapper<Location> {
	@Override
	public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
		Location location = new Location();
		location.setDescription(rs.getString("description"));
		location.setLocationType(LocationType.get(rs.getInt("location_type")));
		return location;
	}

	@Override
	public String getTableName() {
		return "Location";
	}
}
