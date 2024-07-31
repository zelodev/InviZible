/*
    This file is part of InviZible Pro.

    InviZible Pro is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    InviZible Pro is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with InviZible Pro.  If not, see <http://www.gnu.org/licenses/>.

    Copyright 2019-2024 by Garmatin Oleksandr invizible.soft@gmail.com
 */

package pan.alexander.tordnscrypt.utils.connectionchecker

import pan.alexander.tordnscrypt.utils.logger.Logger.loge
import java.net.Authenticator
import java.net.PasswordAuthentication

object ProxyAuthManager {

    fun setDefaultAuth(proxyUser: String, proxyPass: String) =
        try {
            if (proxyUser.isNotEmpty() || proxyPass.isNotEmpty()) {
                Authenticator.setDefault(getAuth(proxyUser, proxyPass))
            } else {
                Unit
            }
        } catch (e: Exception) {
            loge("ProxyAuthManager setDefaultAuth", e)
        }

    private fun getAuth(user: String?, password: String): Authenticator =
        object : Authenticator() {
            public override fun getPasswordAuthentication(): PasswordAuthentication {
                return (PasswordAuthentication(user, password.toCharArray()))
            }
        }
}
