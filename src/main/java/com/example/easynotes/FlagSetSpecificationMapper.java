package com.example.easynotes;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.mapper.pojo.FlagSet;
import com.mapper.pojo.FlagSetSpecificationStudyDef;
import com.mapper.pojo.NVSFlagSet;
import com.mapper.pojo.NVSSpecificSet;

@Mapper
public abstract class FlagSetSpecificationMapper {
	
	public static final FlagSetSpecificationMapper INSTANCE = Mappers.getMapper(FlagSetSpecificationMapper.class);
	
	public abstract FlagSetSpecificationStudyDef mapFromNVSSpecificSetTo(NVSSpecificSet nvsSpecificSet);
	
	@Mapping(target = "compataror", source = "nVSFlagSet.compatarorVal")
	@Mapping(target = "conValue", source = "nVSFlagSet.compatarorVal")
	@Mapping(target = "siValue", source = "nVSFlagSet.comSIValue")
	public abstract FlagSet nVSFlagSetToFlagSet(NVSFlagSet nVSFlagSet);
}
