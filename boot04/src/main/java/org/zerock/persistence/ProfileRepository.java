package org.zerock.persistence;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
