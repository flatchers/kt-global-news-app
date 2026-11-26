package com.example.globalnews.presentation.screen

import android.text.method.PasswordTransformationMethod
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.globalnews.R
import com.example.globalnews.presentation.navigation.Screen
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.globalnews.presentation.screen.viewmodel.LoginScreenViewModel
import com.example.globalnews.presentation.ui.component.StyledButton

@Composable
fun LoginScreen(
    onNavigateTo: (Screen) -> Unit = {},
    viewModel: LoginScreenViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            fontSize = 50.sp,
            modifier = Modifier.padding(top = 60.dp)
        )
        Image(
            painter = painterResource(R.drawable.login),
            contentDescription = "News app login description"
        )
        OutlinedTextField(
            value = viewModel.email,
            onValueChange = viewModel::update_email,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Email),
                    contentDescription = null
                )
            },
            placeholder = {
                Text(text = stringResource(id = R.string.enter_email))
            }
        )
        OutlinedTextField(
            value = viewModel.password,
            onValueChange = viewModel::update_password,
            leadingIcon = {
                Icon(
                    painter = rememberVectorPainter(image = Icons.Outlined.Lock),
                    contentDescription = null
                )
            },
            modifier = Modifier.padding(top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            placeholder = {
                Text(text = stringResource(id = R.string.enter_password))
            }
        )
        StyledButton(
            onClick = {},
            modifier = Modifier
                .padding(30.dp)
            ) {
            Text(
                text = stringResource(id = R.string.login),
                modifier = Modifier.clickable{
                    onNavigateTo(Screen.Main)
                }
            )
        }
        Text(
            text = stringResource(id = R.string.no_account_register),
            modifier = Modifier.clickable {
                onNavigateTo(Screen.Register)
            }
        )
    }
}


@Composable
@Preview(showBackground = true)
fun LoginScreenPreview() {
    LoginScreen()
}

