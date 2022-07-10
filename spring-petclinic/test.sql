select
  distinct owner0_.id as id1_0_,
           owner0_.first_name as first_na2_0_,
           owner0_.last_name as last_nam3_0_,
           owner0_.address as address4_0_,
           owner0_.age as age5_0_,
           owner0_.city as city6_0_,
           owner0_.telephone as telephon7_0_
from
  owners owner0_
    left outer join
  pets pets1_
  on owner0_.id=pets1_.owner_id
where
    owner0_.first_name like ? limit ?
Hibernate:
select
  pets0_.owner_id as owner_id5_1_0_,
  pets0_.id as id1_1_0_,
  pets0_.id as id1_1_1_,
  pets0_.name as name2_1_1_,
  pets0_.birth_date as birth_da3_1_1_,
  pets0_.type_id as type_id4_1_1_,
  pettype1_.id as id1_3_2_,
  pettype1_.name as name2_3_2_
from
  pets pets0_
    left outer join
  types pettype1_
  on pets0_.type_id=pettype1_.id
where
    pets0_.owner_id=?
order by
  pets0_.name
