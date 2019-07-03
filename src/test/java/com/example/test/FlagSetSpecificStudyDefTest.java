package com.example.test;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.example.easynotes.FlagSetSpecificationMapper;
import com.mapper.pojo.FlagSetSpecificationStudyDef;
import com.mapper.pojo.NVSAgeRange;
import com.mapper.pojo.NVSFlagSet;
import com.mapper.pojo.NVSSpecificSet;



public class FlagSetSpecificStudyDefTest {
	
	@Test
	public void testFlagSetSpecificStudyDefMethod() {
		NVSSpecificSet nvsSpecificSet = createAndSetObject();
		
		//call the instance method
		FlagSetSpecificationStudyDef flagSetSpecificationStudyDefTarget 
		= FlagSetSpecificationMapper.INSTANCE.mapFromNVSSpecificSetTo(nvsSpecificSet);
		
		assertThat(flagSetSpecificationStudyDefTarget.getAge()).isEqualTo( "21" );
		assertThat(flagSetSpecificationStudyDefTarget.getAgeRanges().get(0).getLowerLimit()).isEqualTo("11");
		
		assertThat(flagSetSpecificationStudyDefTarget.getAgeRanges().get(0).getFlagSets().get(0).getCompataror()).isEqualTo("<");
		assertThat(flagSetSpecificationStudyDefTarget.getAgeRanges().get(0).getFlagSets().get(0).getConValue()).isEqualTo("36.3");
		assertThat(flagSetSpecificationStudyDefTarget.getAgeRanges().get(0).getFlagSets().get(0).getSiValue()).isEqualTo("36.3");
	}

	private NVSSpecificSet createAndSetObject() {
		NVSSpecificSet NVSSpecificSet =new NVSSpecificSet();
		NVSSpecificSet.setAge("21");
		NVSSpecificSet.setHeight("5.10");
		
		List<NVSAgeRange> ageRanges = new ArrayList<>();
		NVSAgeRange ageRange= new NVSAgeRange();
		
		ageRange.setDesc("Age range desc");
		ageRange.setLowerLimit("11");
		ageRange.setUpperLimit("41");
		
		List<NVSFlagSet> flagSets = new ArrayList<>();
		NVSFlagSet flagSet=new NVSFlagSet();
		
		flagSet.setCompatarorVal("<=36.3");
		flagSet.setComSIValue("<=36.3");
		
		flagSets.add(flagSet);
		ageRange.setFlagSets(flagSets);
		
		ageRanges.add(ageRange);
		NVSSpecificSet.setAgeRanges(ageRanges);
		
		return NVSSpecificSet;
	}

}
